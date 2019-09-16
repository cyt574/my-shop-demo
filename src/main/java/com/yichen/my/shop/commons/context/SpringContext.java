package com.yichen.my.shop.commons.context;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContext implements ApplicationContextAware, DisposableBean {

    private static final Logger logger = LoggerFactory.getLogger(SpringContext.class);

    private static ApplicationContext applicationContext;

    public static <T> T getBean(String beanId) {
        assertContextInjected();
        return (T) applicationContext.getBean(beanId);
    }

    public static <T> T getBean(Class<T> tClass) {
        assertContextInjected();
        return applicationContext.getBean(tClass);
    }

    public void destroy() throws Exception {
        logger.debug("application destroy");
        applicationContext = null;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContext.applicationContext = applicationContext;
    }

    private static void assertContextInjected() {
        Validate.validState(applicationContext != null, "spring-context.xml未配置SpringContext对象");
    }
}
