package cn.xy.springframework.context.support;

import cn.xy.springframework.beans.BeansException;
import cn.xy.springframework.beans.factory.config.BeanPostProcessor;
import cn.xy.springframework.context.ApplicationContext;
import cn.xy.springframework.context.ApplicationContextAware;

/**
 * @author xiangyu
 * @date 2022-03-20 22:57
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {
    private final ApplicationContext applicationContext;


    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(this.applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
