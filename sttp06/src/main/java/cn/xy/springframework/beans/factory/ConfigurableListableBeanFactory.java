package cn.xy.springframework.beans.factory;

import cn.xy.springframework.beans.BeansException;
import cn.xy.springframework.beans.factory.config.AutowireCapableBeanFactory;
import cn.xy.springframework.beans.factory.config.BeanDefinition;
import cn.xy.springframework.beans.factory.config.ConfigurableBeanFactory;


/**
 * Configuration interface to be implemented by most listable bean factories.
 * In addition to {@link ConfigurableBeanFactory}, it provides facilities to
 * analyze and modify bean definitions, and to pre-instantiate singletons.
 * <p>
 * 配置接口是由有助于实现 可以列出最多的bean工厂。除了{@link  ConfigurableBeanFactory},它提供设施来分析和修改Bean定义和pre-instantiate单例
 * <p>
 * 提供分析和修改Bean以及预先实例化的接口操作，不过目前只有一个方法，后续扩充
 *
 * @author xiangyu
 * @date 2022-02-28 23:24
 */
public interface ConfigurableListableBeanFactory extends
        ConfigurableBeanFactory, AutowireCapableBeanFactory,ListableBeanFactory {

    /**
     * @param beanName beanName
     * @return  beanDefinition
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
