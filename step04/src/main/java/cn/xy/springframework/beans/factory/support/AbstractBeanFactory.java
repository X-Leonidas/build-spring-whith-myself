package cn.xy.springframework.beans.factory.support;

import cn.xy.BeansException;
import cn.xy.springframework.beans.factory.BeanFactory;
import cn.xy.springframework.beans.factory.config.BeanDefinition;

/**
 * bean factory 获取bean对象的能力
 * <p>
 * 获取和注册bean definition的接口
 *
 * @author XiangYu
 * @date 2021-09-08-23:43
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

    private <T> T doGetBean(final String name, final Object[] args) {
        // 寻找单例
        Object bean = getSingleton(name);
        if (bean != null) {
            return (T) bean;
        }
        // 如果找不到，通过bean definition 定义一个
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T) createBean(name, beanDefinition, args);
    }

    /**
     * 获取 bean definition
     * @param beanName beanName
     * @return definition
     * @throws BeansException 找不到bean definition 异常
     */
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 创建 bean bean
     * @param beanName beanName
     * @param beanDefinition beanDefinition
     * @param args args
     * @return bean
     * @throws BeansException 创建bean异常
     */
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
