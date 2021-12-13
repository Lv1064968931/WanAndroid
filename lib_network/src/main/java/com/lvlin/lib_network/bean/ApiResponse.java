package com.lvlin.lib_network.bean;

public class ApiResponse<T> {

    public static final int CODE_SUCCESS = 0;
    public static final int CODE_ERROR = 1;

    private int errorCode;//状态码
    private String errorMsg;//错误信息
    private T data;//数据

    public ApiResponse(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = null;
    }
    public ApiResponse(int errorCode, String errorMsg, T data) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
