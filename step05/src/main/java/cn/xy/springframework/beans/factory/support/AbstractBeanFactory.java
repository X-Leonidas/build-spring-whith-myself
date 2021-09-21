package cn.xy.springframework.beans.factory.support;

import cn.xy.springframework.beans.factory.BeansException;
import cn.xy.springframework.beans.factory.BeanFactory;
import cn.xy.springframework.beans.factory.config.BeanDefinition;

/**
 * bean factory 获取bean对象的能力
 * <p>
 * 获取和注册bean definition的接口
 *
 * @author XiangYu
 * @create2021-09-08-23:43
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        return doGetBean(name, null);
    }


    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return doGetBean(name, args);
    }


    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    private <T> T doGetBean(final String name, final Object[] args) {
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
