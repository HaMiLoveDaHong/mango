package com.louis.mango.core.http;

import lombok.Data;
import org.apache.http.HttpStatus;

/**
 * Http 结果封装
 * @quthor haMi
 * @date2019/10/27
 */
@Data
public class HttpResult {

    /**
     * 状态码
     */
    private int code = 200;

    /**
     * 接口信息
     */
    private String msg = "success";

    /**
     * 数据
     */
    private Object data;

    public static HttpResult error(){
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR,"未知异常，请联系管理员");
    }

    public static HttpResult error(String msg){
      return error(HttpStatus.SC_INTERNAL_SERVER_ERROR,msg);
    }

    public static HttpResult error(int code,String msg){
        HttpResult httpResult = new HttpResult();
        httpResult.setCode(code);
        httpResult.setMsg(msg);
        return httpResult;
    }

    public static HttpResult ok(){
        return new HttpResult();
    }

    public static HttpResult ok(String msg){
        HttpResult httpResult = new HttpResult();
        httpResult.setMsg(msg);
        return httpResult;
    }

    public HttpResult ok(Object data){
        HttpResult httpResult = new HttpResult();
        httpResult.setData(data);
        return httpResult;
    }

    public HttpResult ok(Object data,String msg){
        HttpResult httpResult = new HttpResult();
        httpResult.setData(data);
        httpResult.setMsg(msg);
        return httpResult;
    }
}
