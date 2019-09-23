package com.zgph.utils;



import lombok.Data;

import java.io.Serializable;

/**
 * @author sangfor
 */
@Data
public class Result<T> implements Serializable {

    private Integer code;

    private T data;

    private String message;

    public Result() {
        this.code = 0;
    }


    public Result(T data) {
        this.data = data;
        this.code = 0;
    }

    public Result(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public Result(Integer code, T data, String message) {
        this.code = code;
        this.data = data;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
