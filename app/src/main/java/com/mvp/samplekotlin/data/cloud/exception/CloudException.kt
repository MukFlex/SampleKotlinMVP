package com.mvp.samplekotlin.data.cloud.exception

import com.mvp.samplekotlin.data.wrappers.Message
import java.io.IOException

class CloudException : IOException {

    private var fullMessage: Message? = null

    constructor(exception: Exception) : super(exception) {

    }

    constructor(message: Message) : super(message.text) {
        this.fullMessage = message
    }

    fun getFullMessage(): Message? {
        return fullMessage
    }
}