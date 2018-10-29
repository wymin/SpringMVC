package com.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wymin on 2018/10/29 14:17
 */
@Controller
public class BaseController {

    /**
     * 跳转至登录页面
     */
    @RequestMapping(value = "/login_main")
    public String loginMain(){
        return "login";
    }


    /**
     * 登录校验
     */
    @RequestMapping(value = "/login")
    public @ResponseBody Map<String,String> login(HttpServletRequest request){
        Map<String,String[]> map = request.getParameterMap();
        Map<String,String> responMap = new HashMap<String, String>();
        String[] account = map.get("account");
        String[] password = map.get("password");
        System.out.println("account:"+account[0]+">>>>>>>>>>>>>password:"+password[0]);
        if("admin".equals(account[0]) && "1412".equals(password[0])){
            responMap.put("status","success");
        }else{
            responMap.put("status","failure");
        }
        return responMap;
    }

    /**
     * 跳转至主页
     */
    @RequestMapping(value = "/main")
    public String main(){
        return "main";
    }

}
