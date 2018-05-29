package com.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * SpringMVC Controller Demo
 */
@Controller
public class DemoController {

    @RequestMapping(value = "/login")
    public String login(){
        return "main";
    }

    /**
     * REST风格，基于模板，请求方式../test2/1
     * @return
     */
    @RequestMapping(value = "/test/{id}", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> testPost(@PathVariable("id") Long id){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("method","POST");
        map.put("id",id);
        System.out.println("Post===>id="+id);
        return map;
    }

    /**
     * 传统的请求方式../test2?id=1
     * @param id
     * @return
     */
    @RequestMapping(value = "/test2", method = RequestMethod.POST)
    public @ResponseBody Map<String,Object> testPost2(@RequestParam(value = "id", defaultValue = "0",required = false) Long id){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("method","Post,RequestParam");
        map.put("id",id);
        System.out.println("Post===>id="+id);
        return map;
    }

    @RequestMapping(value = "/test/{id}", method = RequestMethod.PUT)
    public @ResponseBody Map<String,Object> testPut(@PathVariable("id") Long id){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("method","PUT");
        map.put("id",id);
        System.out.println("Put===>id="+id);
        return map;
    }

    @RequestMapping(value = "/test/{id}", method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> testGet(@PathVariable("id") Long id){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("method","GET");
        map.put("id",id);
        System.out.println("Get===>id="+id);
        return map;
    }

    @RequestMapping(value = "/test/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Map<String,Object> testDelete(@PathVariable("id") Long id){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("method","DELETE");
        map.put("id",id);
        System.out.println("Delete===>id="+id);
        return map;
    }

    @RequestMapping(value = "/test")
    public void test(){
        System.out.println("normal");
    }

}
