package com.mvp.samplekotlin.data.model.login


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Login {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("full_name")
    @Expose
    var fullName: String? = null
    @SerializedName("alias_name")
    @Expose
    var aliasName: String? = null
    @SerializedName("group_id")
    @Expose
    var groupId: String? = null
    @SerializedName("email")
    @Expose
    var email: String? = null
    @SerializedName("phone")
    @Expose
    var phone: String? = null
    @SerializedName("profile_pic_id")
    @Expose
    var profilePicId: String? = null
    @SerializedName("is_confirm")
    @Expose
    var isConfirm: String? = null
    @SerializedName("is_online")
    @Expose
    var isOnline: String? = null
    @SerializedName("is_verified")
    @Expose
    var isVerified: String? = null
    @SerializedName("is_vip")
    @Expose
    var isVip: String? = null
    @SerializedName("activated")
    @Expose
    var activated: String? = null
    @SerializedName("created_date")
    @Expose
    var createdDate: String? = null
    @SerializedName("profile_img")
    @Expose
    var profileImg: String? = null
    @SerializedName("oauth_token")
    @Expose
    var oauthToken: String? = null
    @SerializedName("online_status")
    @Expose
    var onlineStatus: String? = null

}
