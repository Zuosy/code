package com.zuo.statemachine.json;

public class RequestJson<T extends Object> {
    private String requestCode = "101";
//    private String responseCode = "";
    private boolean needResponse = true;
    private int protocolId = 30400;
    private String versionName = "v_20180327";
    private String requestAuthor = "com.auto.jsonsdk.client";
//    private String message = "";
    private String messageType = "request";
//    private int statusCode = 0;
    private T data = (T)new Data();

    public String getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }

//    public String getResponseCode() {
//        return responseCode;
//    }
//
//    public void setResponseCode(String responseCode) {
//        this.responseCode = responseCode;
//    }

    public boolean isNeedResponse() {
        return needResponse;
    }

    public void setNeedResponse(boolean needResponse) {
        this.needResponse = needResponse;
    }

    public int getProtocolId() {
        return protocolId;
    }

    public void setProtocolId(int protocolId) {
        this.protocolId = protocolId;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getRequestAuthor() {
        return requestAuthor;
    }

    public void setRequestAuthor(String requestAuthor) {
        this.requestAuthor = requestAuthor;
    }

//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

//    public int getStatusCode() {
//        return statusCode;
//    }
//
//    public void setStatusCode(int statusCode) {
//        this.statusCode = statusCode;
//    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
