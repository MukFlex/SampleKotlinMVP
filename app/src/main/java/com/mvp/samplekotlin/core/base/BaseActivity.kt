package com.mvp.samplekotlin.core.base

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.view.View
import com.mvp.samplekotlin.R
import com.mvp.samplekotlin.utils.common.ResourceUtils

abstract class BaseActivity : BaseCoreActivity() {
    private var connectionFiler: IntentFilter? = null
    private var internetConnectionStatus: Boolean = false
    private var isScreenFirstTime: Boolean = false
    private var CoordinatorLayout: View? = null

    /**
     * return coordinatorview to show snackbar
     */
    abstract fun setCoordinatorLayout(): View?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoordinatorLayout = setCoordinatorLayout()
        initializeFilter()
        // register internet connection broadcastReciver
        registerReceiver(mConnectionReceiver, connectionFiler)
    }

    override fun onDestroy() {
        unregisterReceiver(mConnectionReceiver)
        super.onDestroy()
    }

    /**
     * BroadcastReceiver to listen internet status change
     */
    private val mConnectionReceiver = object : BroadcastReceiver() {

        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action.equals(
                            ConnectivityManager.CONNECTIVITY_ACTION)) {

                val connectivityManager: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val ni: NetworkInfo? = connectivityManager.activeNetworkInfo

                if (ni != null && ni.isAvailable && ni.isConnected) {
                    internetConnectionStatus = true
                    if (isScreenFirstTime) {
                        val snackbar = Snackbar
                                .make(CoordinatorLayout as CoordinatorLayout, "Internet is available", Snackbar.LENGTH_LONG)
                                .setActionTextColor(ResourceUtils.getColorFromResource(context, R.color.colorPrimaryDark))
//                                .setAction("RETRY") {
//                                    val snackbar1 = Snackbar.make(CoordinatorLayout, "Message is restored!", Snackbar.LENGTH_SHORT)
//
//                                    snackbar1.show()
//                                }
                        snackbar.show()
                    }
                    isScreenFirstTime = true
                } else {

                    internetConnectionStatus = false
                    val snackbar = Snackbar
                            .make(CoordinatorLayout as CoordinatorLayout, "Internet not available", Snackbar.LENGTH_INDEFINITE)
                    snackbar.show()
                    isScreenFirstTime = true
                }


            }
        }
    }

    /**
     * IntentFilter for internet broadcast
     */
    private fun initializeFilter() {
        connectionFiler = IntentFilter()
        connectionFiler?.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
    }

    /**
     * if internet available then return true otherwise false
     */

    fun isInternetAvailable(): Boolean {
        return internetConnectionStatus;
    }
}