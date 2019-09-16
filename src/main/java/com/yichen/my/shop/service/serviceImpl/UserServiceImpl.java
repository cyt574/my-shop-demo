package com.yichen.my.shop.service.serviceImpl;

import com.yichen.my.shop.commons.context.SpringContext;
import com.yichen.my.shop.dao.UserDao;
import com.yichen.my.shop.entity.User;
import com.yichen.my.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service(value = "userService")
public class UserServiceImpl implements UserService {

//    private UserDao userDao = SpringContext.getBean("userDao");

    @Autowired
    UserDao userDao;

    public User login(String email, String password) {
        return userDao.getUser(email, password);
    }
}
