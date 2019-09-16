package com.yichen.my.shop.commons.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class SpringContextInstance {
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[]{"spring-context.xml"});

//    static {
//        ctx = new ClassPathXmlApplicationContext(new String[]{"spring-context.xml"});
//    }

    public static ApplicationContext getApplicationContext() {
        return ctx;
    }

    public static Object getBean(String beanId) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring-context.xml"});
        return context.getBean(beanId);
    }
}
