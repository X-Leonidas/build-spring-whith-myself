package cn.xy.springframework.beans.factory.support.strategy;

import cn.xy.springframework.beans.factory.BeansException;
import cn.xy.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author XiangYu
 * @create2021-09-15-22:11
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;

}
