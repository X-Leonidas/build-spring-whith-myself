package cn.xy.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.xy.springframework.beans.BeansException;
import cn.xy.springframework.beans.PropertyValues;
import cn.xy.springframework.beans.PropertyValue;
import cn.xy.springframework.beans.factory.config.BeanDefinition;
import cn.xy.springframework.beans.factory.config.BeanReference;
import cn.xy.springframework.beans.factory.support.strategy.CglibSubclassingInstantiationStrategy;
import cn.xy.springframework.beans.factory.support.strategy.InstantiationStrategy;

import java.lang.reflect.Constructor;
import java.util.Objects;

/**
 * @author xiangyu
 * @date 2022-02-22 22:37
 * <p>
 *  实现了获取bean实例 填充属性的能力
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
        Object bean;
        try {
            bean = createBeanInstantiation(beanDefinition, beanName, args);
            applyPropertyValues(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {

                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getReferenceBeanName());
                }

                // 属性填充
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new BeansException("Error setting property values：" + beanName);
        }

    }


    protected Object createBeanInstantiation(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Class<?> beanClass = beanDefinition.getBeanClass();
        Constructor<?> constructor = null;
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();

        for (Constructor<?> declaredConstructor : declaredConstructors) {
            if (Objects.nonNull(args) && declaredConstructor.getParameterTypes().length == args.length) {
                constructor = declaredConstructor;
                break;
            }
        }

        return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructor, args);
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }
}
