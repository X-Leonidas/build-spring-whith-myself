package cn.xy.springframework.beans.factory.config;

import cn.xy.springframework.beans.factory.BeanFactory;
import cn.xy.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * Configuration interface to be implemented by most bean factories. Provides
 * facilities to configure a bean factory, in addition to the bean factory
 * client methods in the {@link BeanFactory}
 * interface.
 *
 * 大多数bean配置接口实现的工厂。提供设施配置bean工厂,除了bean工厂{@link BeanFactory}接口中的方法
 *  可以获取BeanPostProcessor，BeanClassLoader等的一个配置化接口
 * @author xinagyu
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory ,SingletonBeanRegistry {
    /**
     * 作用域
     */
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";
}
