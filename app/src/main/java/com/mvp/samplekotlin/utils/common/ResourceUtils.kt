package com.mvp.samplekotlin.utils.common


import android.content.Context
import android.content.res.Resources
import android.support.v4.content.ContextCompat
import android.text.TextUtils

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader

object ResourceUtils {

    /**
     * @param mContext
     * @return
     */
    private fun getResource(mContext: Context): Resources {
        return mContext.resources
    }

    /**
     * @param context
     * @param resourceId
     * @return
     */
    fun getStringFromResource(context: Context, resourceId: Int): String {
        return context.getString(resourceId)
    }

    /**
     * @param context
     * @param colorId
     * @return
     */
    fun getColorFromResource(context: Context, colorId: Int): Int {
        return ContextCompat.getColor(context, colorId)
    }

    /**
     * @param context
     * @param resourceId
     * @return
     */
    fun getStringArrayFromResource(context: Context, resourceId: Int): Array<String> {
        return context.resources.getStringArray(resourceId)
    }

    /**
     * @param context
     * @param resourceId
     * @return
     */
    fun getIntFromResource(context: Context, resourceId: Int): Int {
        return getResource(context).getInteger(resourceId)
    }

    /**
     * @param context
     * @param resourceId
     * @return
     */
    fun getIntArrayFromResource(context: Context, resourceId: Int): IntArray {
        return getResource(context).getIntArray(resourceId)
    }

    /**
     * @param context
     * @param resourceId
     * @return
     */
    fun getBoolean(context: Context, resourceId: Int): Boolean {
        return getResource(context).getBoolean(resourceId)
    }

    /**
     * @param context
     * @param fileName
     * @return
     */
//    fun geFileFromAssets(context: Context?, fileName: String): String? {
//        if (context == null || ValidationUtils.isFieldEmpty(fileName)) {
//            return null
//        }
//
//        val s = StringBuilder("")
//        try {
//            val inputStreamReader:InputStreamReader = InputStreamReader(getInputStreamFromAsset(context, fileName))
//            val br = BufferedReader(inputStreamReader)
//            var line: String
//            while ((line = br.readLine()) != null) {
//                s.append(line)
//            }
//            return s.toString()
//        } catch (e: IOException) {
//            e.printStackTrace()
//            return null
//        }
//
//    }

    /**
     * @param context
     * @param fileName
     * @return
     * @throws IOException
     */
    @Throws(IOException::class)
    fun getInputStreamFromAsset(context: Context, fileName: String): InputStream {
        return context.resources.assets.open(fileName)
    }

    /**
     * @param context
     * @param resId
     * @return
     */
//    fun geFileFromRaw(context: Context?, resId: Int): String? {
//        if (context == null) {
//            return null
//        }
//
//        val s = StringBuilder()
//        try {
//            val inputStreamReader = InputStreamReader(getInputStreamFromRaw(context, resId))
//            val br = BufferedReader(inputStreamReader)
//            var line: String
//            while ((line = br.readLine()) != null) {
//                s.append(line)
//            }
//            return s.toString()
//        } catch (e: IOException) {
//            e.printStackTrace()
//            return null
//        }
//
//    }

    /**
     * @param context
     * @param resId
     * @return
     * @throws IOException
     */
//    @Throws(IOException::class)
//    fun getInputStreamFromRaw(context: Context, resId: Int): InputStream {
//        return context.resources.openRawResource(resId)
//    }
}
