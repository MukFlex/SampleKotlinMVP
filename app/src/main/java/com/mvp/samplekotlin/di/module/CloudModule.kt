package com.mvp.samplekotlin.di.module


import android.util.Log


import com.mvp.samplekotlin.BuildConfig
import com.mvp.samplekotlin.application.MyApplication
import com.mvp.samplekotlin.data.cloud.CloudApi
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mvp.samplekotlin.data.cloud.CloudDataSource
import com.mvp.samplekotlin.data.cloud.util.AuthInterceptor

import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit

import javax.inject.Named
import javax.inject.Singleton
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
class CloudModule {

    @Provides
    @Singleton
    internal fun provideOkHttpCache(application: MyApplication): Cache {
        val cacheSize = 10 * 1024 * 1024 // 10 MiB
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    //    @Provides
    //    @Singleton
    //    AuthInterceptor provideAuthInterceptor(PreferenceManager mSharedPreference) {
    //        return new AuthInterceptor(mSharedPreference);
    //    }

    @Provides
    @Singleton
    internal fun provideAuthInterceptor(): AuthInterceptor {
        return AuthInterceptor()
    }

    @Provides
    @Singleton
    @Named("intercepted")
    internal fun provideOkHttpClient(cache: Cache, authInterceptor: AuthInterceptor): OkHttpClient {

        if (BuildConfig.showHttpLog) {

            val logging = HttpLoggingInterceptor()
            // set your desired log level
            logging.level = HttpLoggingInterceptor.Level.BODY

            val clientBuilder = OkHttpClient().newBuilder()
                    .readTimeout(180, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .cache(cache)
                    .addInterceptor(authInterceptor)
                    .addNetworkInterceptor(StethoInterceptor())
                    .addNetworkInterceptor(logging)

            val client = clientBuilder.build()

            hostnameVerifier(clientBuilder)

            return client

        } else {
            val clientBuilder = OkHttpClient().newBuilder()
                    .readTimeout(180, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .cache(cache)
                    .addInterceptor(authInterceptor)
                    .addNetworkInterceptor(StethoInterceptor())

            hostnameVerifier(clientBuilder)

            return clientBuilder.build()
        }
    }

    private fun hostnameVerifier(clientBuilder: OkHttpClient.Builder) {

        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
            override fun getAcceptedIssuers(): Array<X509Certificate>? {
                return null
            }

            @Throws(CertificateException::class)
            override fun checkServerTrusted(chain: Array<X509Certificate>,
                                            authType: String) {
            }

            @Throws(CertificateException::class)
            override fun checkClientTrusted(chain: Array<X509Certificate>,
                                            authType: String) {
            }
        })

        try {
            val sslContext = SSLContext.getInstance("SSL")

            sslContext.init(null, trustAllCerts, java.security.SecureRandom())
            clientBuilder.sslSocketFactory(sslContext.socketFactory)

        } catch (x: Exception) {

        }

        val hostnameVerifier = HostnameVerifier { hostname, session ->
            Log.d("TAG", "Trust Host :$hostname")
            true
        }
        clientBuilder.hostnameVerifier(hostnameVerifier)
    }

    @Provides
    @Singleton
    @Named("nonintercepted")
    internal fun provideOkHttpClientNonIntercepted(): OkHttpClient {

        if (BuildConfig.showHttpLog) {

            val logging = HttpLoggingInterceptor()
            // set your desired log level
            logging.level = HttpLoggingInterceptor.Level.BODY

            return OkHttpClient().newBuilder()
                    .readTimeout(180, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .addNetworkInterceptor(logging)
                    .build()
        } else {

            return OkHttpClient().newBuilder()
                    .readTimeout(180, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .build()
        }
    }

    @Provides
    @Singleton
    @Named("intercepted")
    internal fun provideApiService(@Named("intercepted") client: OkHttpClient, gsonConverterFactory: GsonConverterFactory): CloudApi {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_ENDPOINT)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
                .create(CloudApi::class.java)
    }

    @Provides
    @Singleton
    @Named("nonintercepted")
    internal fun provideApiServiceNonIntercepted(@Named("nonintercepted") client: OkHttpClient, gsonConverterFactory: GsonConverterFactory): CloudApi {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_ENDPOINT)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
                .create(CloudApi::class.java)
    }
    /*
    @Provides
    @Singleton
    @Named("nonintercepted")
    CloudRepository provideApiServiceNonIntercepted(@Named("nonintercepted") OkHttpClient client, GsonConverterFactory gsonConverterFactory) {
        return (CloudRepository)new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_ENDPOINT)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build()
                .create(CloudApi.class);
    }

    @Provides
    @Singleton
    @Named("intercepted")
    CloudRepository provideApiService(@Named("intercepted") OkHttpClient client, GsonConverterFactory gsonConverterFactory) {
        return (CloudRepository) new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_ENDPOINT)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build()
                .create(CloudApi.class);
    }*/

    @Provides
    @Singleton
    fun gson(): Gson {
        val gsonBuilder = GsonBuilder()
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun gsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    internal fun provideCloudDataSource(@Named("nonintercepted") apiService: CloudApi): CloudDataSource {
        return CloudDataSource(apiService)
    }


}
