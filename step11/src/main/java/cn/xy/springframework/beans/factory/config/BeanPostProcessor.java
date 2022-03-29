package cn.xy.springframework.beans.factory.config;

import cn.xy.springframework.beans.BeansException;

/**
 * @author xiangyu
 * @date 2022-03-09 22:26
 * Factory hook that allows for custom modification of new bean instances,
 * e.g. checking for marker interfaces or wrapping them with proxies.
 */
public interface BeanPostProcessor {

    /**
     * bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean     bean
     * @param beanName bean name
     * @return 处理后的bean
     * @throws BeansException bean exception
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;


    /**
     * 在bean 对象执行初始化方法之后，执行此方法
     *
     * @param bean     bean
     * @param beanName bean name
     * @return 处理后的bean
     * @throws BeansException bean exception
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
