package com.yichen.my.shop.service;

import com.yichen.my.shop.entity.User;

public interface UserService {

    /**
     *
     * @param email
     * @param password
     * @return
     */
    public User login(String email, String password);
}
