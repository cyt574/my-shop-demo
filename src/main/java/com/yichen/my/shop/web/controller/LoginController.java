package com.yichen.my.shop.web.controller;

import com.yichen.my.shop.commons.constant.ConstantUtils;
import com.yichen.my.shop.entity.User;
import com.yichen.my.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController{

    @Autowired
    UserService userService;

    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {

        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "email", required = true) String email, @RequestParam(value = "password", required = true)String password, HttpServletRequest request) {
        User user = userService.login(email, password);
        if( user == null) {
            return login();
        } else {
            request.getSession().setAttribute(ConstantUtils.SESSION_USER, user);
            return "redirect:main";
        }
    }
}