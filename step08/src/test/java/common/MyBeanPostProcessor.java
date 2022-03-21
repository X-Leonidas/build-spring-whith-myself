package common;

import bean.UserService;
import cn.xy.springframework.beans.BeansException;
import cn.xy.springframework.beans.factory.config.BeanPostProcessor;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("开始执行bean 增强");
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}
