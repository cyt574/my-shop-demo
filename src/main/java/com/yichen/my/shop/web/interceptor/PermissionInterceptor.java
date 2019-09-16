package com.yichen.my.shop.web.interceptor;

import com.yichen.my.shop.commons.constant.ConstantUtils;
import com.yichen.my.shop.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PermissionInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView.getViewName().endsWith("login")) {
            User user = (User) request.getSession().getAttribute(ConstantUtils.SESSION_USER);
            if(user != null) {
                response.sendRedirect("/main");
            }
        }
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
