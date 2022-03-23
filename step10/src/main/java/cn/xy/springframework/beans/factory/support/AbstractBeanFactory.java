package cn.xy.springframework.beans.factory.support;

import cn.xy.springframework.beans.BeansException;
import cn.xy.springframework.beans.factory.FactoryBean;
import cn.xy.springframework.beans.factory.config.BeanDefinition;
import cn.xy.springframework.beans.factory.config.BeanPostProcessor;
import cn.xy.springframework.beans.factory.config.ConfigurableBeanFactory;
import cn.xy.springframework.util.ClassUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author xiangyu
 * @date 2022-02-22 22:10
 */
public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport
        implements ConfigurableBeanFactory {
    /**
     * ClassLoader to resolve bean class names with, if necessary
     */
    private final  ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    /**
     * BeanPostProcessors to apply in createBean
     */
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<>();

    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) {
        return doGetBean(beanName, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return (T) getBean(name);
    }

    private <T> T doGetBean(final String name, Object[] args) {
        Object singleton = getSingleton(name);
        if (Objects.nonNull(singleton)) {
            return (T) getObjectForBeanInstance(singleton, name);
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean, name);
    }


    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        // 异动顺序
        this.beanPostProcessors.remove(beanPostProcessor);
        this.beanPostProcessors.add(beanPostProcessor);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);


    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }

    /**
     * Return the list of BeanPostProcessors that will get applied
     * to beans created with this factory.
     * 返回将应用于使用此工厂创建的 bean 的 BeanPostProcessor 列表。
     */
    public List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }

    private Object getObjectForBeanInstance(Object beanInstance, String beanName) {
        if (!(beanInstance instanceof FactoryBean)) {
            return beanInstance;
        }

        Object bean = getCachedObjectForFactoryBean(beanName);

        if (Objects.isNull(bean)) {
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            bean = getObjectForFactoryBean(factoryBean, beanName);
        }
        return bean;
    }


}
