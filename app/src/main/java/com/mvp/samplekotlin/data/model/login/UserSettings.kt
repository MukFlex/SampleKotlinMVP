package com.mvp.samplekotlin.data.model.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class UserSettings {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("user_id")
    @Expose
    var userId: String? = null
    @SerializedName("language_id")
    @Expose
    var languageId: String? = null
    @SerializedName("notification_status")
    @Expose
    var notificationStatus: String? = null
    @SerializedName("fingerprint_status")
    @Expose
    var fingerprintStatus: String? = null
    @SerializedName("online_status")
    @Expose
    var onlineStatus: String? = null
    @SerializedName("share_profile_status")
    @Expose
    var shareProfileStatus: String? = null
    @SerializedName("show_my_presence")
    @Expose
    var showMyPresence: String? = null
    @SerializedName("show_me_on_map")
    @Expose
    var showMeOnMap: String? = null
    @SerializedName("should_show_me_on_map")
    @Expose
    var shouldShowMeOnMap: String? = null
    @SerializedName("availability_popup")
    @Expose
    var availabilityPopup: String? = null
    @SerializedName("account_status")
    @Expose
    var accountStatus: String? = null
    @SerializedName("join_date_status")
    @Expose
    var joinDateStatus: String? = null
    @SerializedName("membership_notification_status")
    @Expose
    var membershipNotificationStatus: String? = null
    @SerializedName("update_date")
    @Expose
    var updateDate: String? = null
    @SerializedName("profile_percentage")
    @Expose
    var profilePercentage: String? = null

}
