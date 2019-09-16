package com.yichen.my.shop;

import com.yichen.my.shop.dao.Impl.UserDaoImpl;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
    @Test
    public void beanTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserDaoImpl userDao = (UserDaoImpl) context.getBean("userDao");
        Assert.assertNotNull(userDao);
    }
}
