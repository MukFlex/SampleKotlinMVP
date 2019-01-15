package com.mvp.samplekotlin.data.model.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*
 LoginResponse is pojo class which have user to get response data with Retrofit.
 In this application with a good layered architecture, this model would only be the gateway to
 the domain layer or business logic. See it as the provider of the data we want to display
  in the view. Model’s responsibilities include using APIs, caching data, managing databases.
 */

class LoginResponse {

    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("message")
    @Expose
    var message: String? = null
    @SerializedName("data")
    @Expose
    var data: Login? = null
    @SerializedName("user_settings")
    @Expose
    var userSettings: UserSettings? = null

}
