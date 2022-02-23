package cn.xy.springframework.beans.factory.support;

import cn.xy.springframework.beans.factory.config.BeanDefinition;

/**
 * @author xiangyu
 * @date 2022-02-22 22:52
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName beanName
     * @param beanDefinition  beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
