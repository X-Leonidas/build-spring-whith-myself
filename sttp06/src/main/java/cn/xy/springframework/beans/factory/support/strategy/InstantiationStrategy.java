package cn.xy.springframework.beans.factory.support.strategy;

import cn.xy.springframework.beans.BeansException;
import cn.xy.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author xiangyu
 * @date 2022-02-22 22:33
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args) throws BeansException;
}
