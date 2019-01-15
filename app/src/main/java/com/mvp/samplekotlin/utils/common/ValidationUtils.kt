package com.mvp.samplekotlin.utils.common


import android.support.v4.util.PatternsCompat
import android.text.TextUtils

object ValidationUtils {
    /**
     * @param value
     * @return
     */
    fun isFieldEmpty(value: String): Boolean {
        return TextUtils.isEmpty(value) || value.trim { it <= ' ' }.length <= 0
    }

    /**
     * @param value
     * @return
     */
    fun isDigitOnly(value: String): Boolean {
        return !isFieldEmpty(value) && TextUtils.isDigitsOnly(value)
    }

    /**
     * @param value
     * @return
     */
    fun isContainPrintableCharacter(value: String): Boolean {
        return !isFieldEmpty(value) && TextUtils.isGraphic(value)
    }

    /**
     *
     * @param value
     * @return
     */
    fun isEmailValid(value: String): Boolean {
        return !isFieldEmpty(value) && PatternsCompat.EMAIL_ADDRESS.matcher(value).matches()
    }

    /**
     *
     * @param number
     * @return
     */
    fun isMobileNumberValid(number: String?): Boolean {
        return if (number == null) {
            false
        } else {
            android.util.Patterns.PHONE.matcher(number).matches()
        }

    }
}
