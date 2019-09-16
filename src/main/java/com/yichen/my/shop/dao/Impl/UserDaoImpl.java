package com.yichen.my.shop.dao.Impl;
import com.yichen.my.shop.dao.UserDao;
import com.yichen.my.shop.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {

    private final static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    public User getUser(String email, String password) {
        logger.debug("getUser({},{}) function has been userd", email, password);
        User user = null;

        if("admin@chenyt.com".equals(email)) {
            if("admin".equals(password)) {
                user = new User();
                user.setEmail(email);
                user.setPassword(password);
                user.setUsername("chenyitang");
                logger.info("get User {} information succeed", user.getUsername());
                return user;
            }
        } else {
            logger.warn("get User information fail");
        }
        return null;
    }
}
