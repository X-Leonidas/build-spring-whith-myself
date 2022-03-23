package cn.xy.springframework.beans.factory.config;

import cn.xy.springframework.beans.BeansException;
import cn.xy.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author xiangyu
 * @date 2022-03-09 22:21
 * Allows for custom modification of an application context's bean definitions,
 * adapting the bean property values of the context's underlying bean factory.
 *
 *
 *
 * <p>
 * 允许自定义修改 BeanDefinition 属性信息
 */
public interface BeanFactoryPostProcessor {

    /**
     *
     *  在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     * @param beanFactory  beanFactory
     * @throws BeansException beanException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)throws BeansException;
}
