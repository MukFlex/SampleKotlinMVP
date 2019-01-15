package com.mvp.samplekotlin.data.wrappers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseResponse<T> {

    @SerializedName("code")
    @Expose
    private Integer code;

    @SerializedName("status")
    @Expose
    private String status;


    @SerializedName("message")
    @Expose
    private String message= null;

    @SerializedName("data")
    @Expose
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }
    public Integer getCode() {return code;}

    public void setCode(Integer code) {this.code = code;}

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
