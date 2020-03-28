package com.sunyf.common;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.text.MessageFormat;

/**
 * 通用响应对象类
 * @author sunyf
 * @since 2017-06-21
 */
public class CommonResponse<T>{

    private Integer code = 0;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String msg;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data = null;

    public CommonResponse() {
    }

    public CommonResponse(BizErrorCode bizErrorCode) {
        this.code = bizErrorCode.getCode();
        this.msg = bizErrorCode.getDescription();
    }

    public Integer getCode() {
        return code;
    }

    public CommonResponse<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public CommonResponse<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }


    public T getData() {
        return data;
    }


    public CommonResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public boolean succeed(){
        return this.code == 0;
    }

    public static <T> CommonResponse success() {
        return new CommonResponse().setCode(0).setMsg("success");
    }

    public static <T> CommonResponse success(T data) {
        return success(data, "success");
    }

    public static <T> CommonResponse success(T data, String message) {
        return new CommonResponse().setCode(0).setData(data).setMsg(message);
    }

    public static <T> CommonResponse serverError(String message) {
        return new CommonResponse().setCode(BizErrorCodeEnum.UNSPECIFIED.getCode()).setMsg(message);
    }


    public static <T> CommonResponse serverError() {
        return new CommonResponse().setCode(BizErrorCodeEnum.UNSPECIFIED.getCode()).setMsg(BizErrorCodeEnum.UNSPECIFIED.getDescription());
    }

    public static <T> CommonResponse parameterError() {
        return new CommonResponse().setCode(BizErrorCodeEnum.REQUEST_ERROR.getCode()).setMsg(BizErrorCodeEnum.REQUEST_ERROR.getDescription());
    }

    public static <T> CommonResponse parameterError(String msg) {
        String parameterErrorMsg = MessageFormat.format(BizErrorCodeEnum.REQUEST_ERROR.getDescription(), msg);
        return new CommonResponse().setCode(BizErrorCodeEnum.REQUEST_ERROR.getCode()).setMsg(parameterErrorMsg);
    }

    public  static <T> CommonResponse setCodeAndMsg(Integer code, String msg) {
        return new CommonResponse().setCode(code).setMsg(msg);
    }

    public  static <T> CommonResponse setCodeAndMsg(BizErrorCode bizErrorCode) {
        return new CommonResponse().setCode(bizErrorCode.getCode()).setMsg(bizErrorCode.getDescription());
    }

    public static <T> CommonResponse fail(T data) {
        return fail(data, BizErrorCodeEnum.BIZ_DEAL_FAIL.getDescription());
    }

    public static <T> CommonResponse fail() {
        return new CommonResponse().setCode(BizErrorCodeEnum.BIZ_DEAL_FAIL.getCode()).setMsg(BizErrorCodeEnum.BIZ_DEAL_FAIL.getDescription());
    }

    public static <T> CommonResponse fail(T data, String message) {
        return new CommonResponse().setCode(BizErrorCodeEnum.BIZ_DEAL_FAIL.getCode()).setData(data).setMsg(message);
    }

}
