package cn.xy.springframework.beans.factory.support;

import cn.xy.BeansException;
import cn.xy.springframework.beans.factory.config.BeanDefinition;

/**
 *
 * 自动注入bean对象的能力
 *
 * @author XiangYu
 * @create2021-09-08-23:53
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(beanName, bean);
        return bean;
    }
}
