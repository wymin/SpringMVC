package com.system.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by Wymin on 2018/10/29 16:54
 * JSON 工具类
 */
public class JsonUtils {

    public static String HttpResponJson(String content){
        if(StringUtils.isEmpty(content)){
            return null;
        } else {
            return null;
        }
    }


    /**
     * 向页面返回一个错误JSON信息。
     * @param msg
     */
    public static String renderFailure(String msg) {
        return "{\"status\":\"failure\",\"msg\":\""+msg+"\"}";
    }

    /**
     * 向页面返回一个成功JSON信息。
     * @param msg
     */
    public static String renderSuccess(String msg) {
        return "{\"status\":\"success\",\"msg\":\""+msg+"\"}";
    }

}
