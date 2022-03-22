package cn.xy.springframework.beans.factory.support;

import cn.xy.springframework.beans.BeansException;
import cn.xy.springframework.beans.factory.FactoryBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiangyu
 * @date 2022-03-22 21:55
 * <p>
 * Support base class for singleton registries which need to handle
 * {@link FactoryBean} instances,
 * integrated with {@link DefaultSingletonBeanRegistry}'s singleton management.
 */
public abstract class FactoryBeanRegistrySupport extends DefaultSingletonBeanRegistry {
    private final Map<String, Object> factoryBeanObjectCache = new ConcurrentHashMap<>();

    protected Object getCacheedObjectForFactoryBean(String beanName) {
        Object bean = this.factoryBeanObjectCache.get(beanName);
        return bean != NULL_OBJECT ? bean : null;
    }

    protected Object getObjectForFactoryBean(FactoryBean<?> factoryBean, String beanName) {
        if (factoryBean.isSingleton()) {
            Object bean = factoryBeanObjectCache.get(beanName);
            if (bean == null) {
                bean = doGetObjectForFactoryBean(factoryBean, beanName);
                this.factoryBeanObjectCache.put(beanName, bean != null ? bean : NULL_OBJECT);
            }
            return bean;
        } else {
            return doGetObjectForFactoryBean(factoryBean, beanName);
        }
    }

    private Object doGetObjectForFactoryBean(final FactoryBean<?> factoryBean, String beanName) {
        try {
            return factoryBean.getObject();
        } catch (Exception e) {
            throw new BeansException("FactoryBean threw exception on object[" + beanName + "] creation", e);
        }
    }


}
