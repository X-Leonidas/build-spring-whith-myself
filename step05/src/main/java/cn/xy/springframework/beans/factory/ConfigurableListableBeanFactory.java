package cn.xy.springframework.beans.factory;

import cn.xy.springframework.beans.BeansException;
import cn.xy.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.xy.springframework.beans.factory.config.BeanDefinition;
import cn.xy.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 *
 * 配置接口是由最有助于实现bean工厂。除了{@link  ConfigurableBeanFactory},它提供设施来分析和修改Bean定义,pre-instantiate单例
 *
 * 提供分析和修改Bean以及预先实例化的接口操作，不过目前只有一个方法，后续扩充
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
