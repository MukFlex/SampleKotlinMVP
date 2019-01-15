package com.mvp.samplekotlin.utils.common


import com.mvp.samplekotlin.data.cloud.exception.CloudException
import com.mvp.samplekotlin.data.wrappers.Message

import org.json.JSONObject
import retrofit2.HttpException

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader




object ErrorConvert {

    fun convert2CloudException(e: Throwable): CloudException {

        if (e is HttpException) {

            val m = Message()
            m.code = e.code()
            m.text = e.message()

            var reader: BufferedReader? = null
            val sb = StringBuilder()
            try {
                reader = BufferedReader(InputStreamReader(e.response().errorBody()!!.byteStream()))
//                var line: String
                try {
//                    while ((line = reader.readLine()) != null) {
//                        sb.append(line)
//                    }
                    for (line in reader.readLine()) {

                        sb.append(line)

                    }

                } catch (ee: IOException) {
                    ee.printStackTrace()
                }

            } catch (eee: Exception) {
                eee.printStackTrace()
            }

            val finallyError = sb.toString()

            try {
                val jObjError = JSONObject(finallyError)
                m.text = jObjError.getString("Status")
                m.data = jObjError.get("Login")
                m.code = jObjError.get("Code") as Int
                m.errorMsg = jObjError.getString("Error")
            } catch (x: Exception) {

            }

            return CloudException(m)

        } else {
            val m = Message()
            m.text = e.message
            return CloudException(m)
        }

    }
}
