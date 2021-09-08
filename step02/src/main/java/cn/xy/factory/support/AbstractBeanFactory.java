package cn.xy.factory.support;

import cn.xy.BeansException;
import cn.xy.factory.BeanFactory;
import cn.xy.factory.config.BeanDefinition;

/**
 * bean factory 获取bean对象的能力
 *
 * 获取和注册bean definition的接口
 *
 * @author XiangYu
 * @create2021-09-08-23:43
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
