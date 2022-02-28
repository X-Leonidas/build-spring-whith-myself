package cn.xy.springframework.beans.factory.support;

import cn.xy.springframework.beans.BeansException;
import cn.xy.springframework.beans.factory.BeanFactory;
import cn.xy.springframework.beans.factory.config.BeanDefinition;

import java.util.Objects;

/**
 * @author xiangyu
 * @date 2022-02-22 22:10
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) {
        return doGetBean(beanName, args);
    }


    private <T> T doGetBean(String name, Object[] args) {
        Object singleton = getSingleton(name);
        if (Objects.nonNull(singleton)) {
            return (T) singleton;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        // TODO： 通过bean类型获取bean
        return (T) getBean(name);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);


    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);
}
