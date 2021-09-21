package cn.xy.springframework.beans.factory.support;

import cn.xy.springframework.beans.factory.config.BeanDefinition;

/**
 * @author XiangYu
 * @create2021-09-09-0:12
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
