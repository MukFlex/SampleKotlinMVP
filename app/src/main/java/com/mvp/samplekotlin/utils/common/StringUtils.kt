package com.mvp.samplekotlin.utils.common


import android.text.Html

object StringUtils {
    /**
     * convert HTML  string
     * @param value
     * @return
     */
    fun setHtmlContent(value: String): String {
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            Html.fromHtml(value, Html.FROM_HTML_MODE_LEGACY).toString()
        } else {
            Html.fromHtml(value).toString()
        }
    }
}
