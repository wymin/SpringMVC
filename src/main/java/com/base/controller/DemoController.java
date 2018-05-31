package com.base.controller;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
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

    /**
     * Controller Method Demo
     * value : 指定请求的实际地址，指定的地址可以是URI Template 模式
     * method : 指定请求的method类型， GET、POST、PUT、DELETE等
     * params : 指定request中必须包含某些参数值时，才让该方法处理。
     * headers :  指定request中必须包含某些指定的header值，才能让该方法处理请求。
     * consumes : 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;
     * produces :  指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回；
     */
    @RequestMapping(value="/test",method=RequestMethod.POST, params={"id","value!=1"}, headers={ "Accept-Language=US,zh;q=0.8" }, consumes="application/json", produces="application/json")
    public @ResponseBody Map<String,Object> test(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("method","test");
        System.out.println("test");
        return map;
    }

    /**
     * HttpServlet做参数，并向页面输出一个字符串
     * @param request
     * @param response
     * @param writer
     */
    @RequestMapping(path = "/test_servlet")
    public void testServlet(HttpServletRequest request, HttpServletResponse response, Writer writer){
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("method","test_servlet");
            jsonObject.put("request",request.toString());
            jsonObject.put("response",response.toString());
            writer.write(jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/test_model")
    public ModelAndView testModel(){
        String viewname = "main";
        ModelAndView modelAndView = new ModelAndView(viewname);
        modelAndView.addObject("time", new Date());
        System.out.println("111");
        return modelAndView;
    }
}
