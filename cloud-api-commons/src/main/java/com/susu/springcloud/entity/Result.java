package com.susu.springcloud.entity;

import lombok.Data;

/**
 * @author sujay
 * @version 21:55 2022/2/19
 */
@Data
public class Result<T>  {

    public static final int ERROR = 400;
    
    private int code = 200;

    private String msg = "操作成功";

    private T data;

    public Result() {

    }

    public Result(String msg,T data) {
        this.setMsg(msg);
        this.setData(data);
    }

    public Result(T data) {
        this.setData(data);
    }

    public Result<T> ok() {
        return this;
    }

    public Result<T> ok(T data) {
        this.setData(data);
        return this;
    }

    public Result<T> error() {
        this.setCode(ERROR);
        this.setMsg("操作失败");
        return this;
    }

    public Result<T> error(String msg) {
        this.setCode(ERROR);
        this.setMsg(msg);
        return this;
    }

    public Result<T> error(T data) {
        this.setData(data);
        this.setCode(ERROR);
        this.setMsg("操作失败");
        return this;
    }

    public Result<T> error(int code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
        return this;
    }
    public Result<T> error(T data, String msg) {
        this.setData(data);
        this.setCode(ERROR);
        this.setMsg(msg);
        return this;
    }

    public Result<T> error(T data, int code, String msg) {
        this.setData(data);
        this.setCode(code);
        this.setMsg(msg);
        return this;
    }

}
