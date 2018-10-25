package com.yangli.springbootWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

//    @RequestMapping({"/","/index"}) //已在MyMvcConfig类中进行了视图访问配置，详细请看MyMvcConfig类
//    public String goLogin(){
//        return "login";
//    }

    @PostMapping("/user/login")
    public String goDashboard(String username, String password, Map<String,Object> map, HttpSession session){
        if (!StringUtils.isEmpty(username) && "abcd1234".equals(password)){
            //登录成功 前往后台首页  为了避免表单重复提交可以重定向到后台首页
            //main.html已经在MyMvcConfig中进行了映射到dashboard页面
            session.setAttribute("username",username);
            return "redirect:/main.html";
        }else {
            //登录失败  回到登录界面  并返回提示信息
            map.put("msg","用户名或者密码错误，登录失败！");
            return "login";
        }
    }

}
