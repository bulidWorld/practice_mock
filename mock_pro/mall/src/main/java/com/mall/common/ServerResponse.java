package com.mall.common;


import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/22.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable{
    private int status;

    private String msg;

    private T data;

    private ServerResponse(int status){
        this.status = status;
    }

    private ServerResponse(int status, String msg){
        this.msg = msg;
        this.status = status;
    }

    private ServerResponse(int status, T t){
        this.data = t;
    }

    private ServerResponse(int status, T t, String msg){
        this.data = t;
        this.status = status;
        this.msg = msg;
    }

    public static<T> ServerResponse<T> createBySuccess(){
        return new ServerResponse<T>(ErrorCode.SUCCESS);
    }

    public static<T> ServerResponse<T> createByErrorCode(int errorCode){
        return new ServerResponse<T>(errorCode);
    }

    public static<T> ServerResponse<T> createByErrorCode(int errorCode, String msg){
        return new ServerResponse<T>(errorCode, msg);
    }

    public static<T> ServerResponse<T> createByErrorCode(int errorCode, String msg, T t){
        return new ServerResponse<T>(errorCode, t, msg);
    }

    public static<T> ServerResponse<T> createBySuccessMsg(String msg){
        return new ServerResponse<T>(ErrorCode.SUCCESS, msg);
    }

    public static<T> ServerResponse<T> createBySuccess(T t){
        return new ServerResponse<T>(ErrorCode.SUCCESS, t);
    }

    public static<T> ServerResponse<T> createBySuccess(T t, String msg){
        return new ServerResponse<T>(ErrorCode.SUCCESS, t, msg);
    }

    public static<T> ServerResponse<T> createByError(T t){
        return new ServerResponse<T>(ErrorCode.FAILED, t);
    }

    public static<T> ServerResponse<T> createByError(T t, String msg){
        return new ServerResponse<T>(ErrorCode.FAILED, t, msg);
    }



}
