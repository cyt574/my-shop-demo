package com.yichen.my.shop.dao;

import com.yichen.my.shop.entity.User;

public interface UserDao {
    /**
     *
     * @param email
     * @param password
     * @return user
     */
    public User getUser(String email, String password);
}
