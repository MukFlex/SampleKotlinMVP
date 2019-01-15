package com.mvp.samplekotlin.data.wrappers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AuthContent {
    @Expose
    @SerializedName("access_token")
    private String accessToken;
    @SerializedName("token_type")
    @Expose
    private String tokenType;
    @SerializedName("expires_in")
    @Expose
    private Integer expiresIn;
    @SerializedName("refresh_token")
    @Expose
    private String refreshToken;
    @SerializedName("deviceId")
    @Expose
    private String deviceId;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName(".issued")
    @Expose
    private String Issued;
    @SerializedName(".expires")
    @Expose
    private String Expires;

    /**
     *
     * @return
     * The accessToken
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     *
     * @param accessToken
     * The access_token
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     *
     * @return
     * The tokenType
     */
    public String getTokenType() {
        return tokenType;
    }

    /**
     *
     * @param tokenType
     * The token_type
     */
    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    /**
     *
     * @return
     * The expiresIn
     */
    public Integer getExpiresIn() {
        return expiresIn;
    }

    /**
     *
     * @param expiresIn
     * The expires_in
     */
    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     *
     * @return
     * The refreshToken
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     *
     * @param refreshToken
     * The refresh_token
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     *
     * @return
     * The deviceId
     */
    public String getDeviceId() {
        return deviceId;
    }

    /**
     *
     * @param deviceId
     * The deviceId
     */
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    /**
     *
     * @return
     * The version
     */
    public String getVersion() {
        return version;
    }

    /**
     *
     * @param version
     * The version
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     *
     * @return
     * The Issued
     */
    public String getIssued() {
        return Issued;
    }

    /**
     *
     * @param Issued
     * The .issued
     */
    public void setIssued(String Issued) {
        this.Issued = Issued;
    }

    /**
     *
     * @return
     * The Expires
     */
    public String getExpires() {
        return Expires;
    }

    /**
     *
     * @param Expires
     * The .expires
     */
    public void setExpires(String Expires) {
        this.Expires = Expires;
    }
    @Override
    public String toString() {
        return "Auth Object: "+" token "+getAccessToken()+" refreshToken: "+getRefreshToken()+" tokenType: "+getTokenType();
    }
}