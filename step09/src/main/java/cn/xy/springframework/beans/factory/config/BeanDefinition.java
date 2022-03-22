package cn.xy.springframework.beans.factory.config;

import cn.xy.springframework.beans.PropertyValues;
import lombok.Data;

/**
 * @author xiangyu
 * @date 2022-02-22 22:16
 */


@Data
public class BeanDefinition {
    private final String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

    private final String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;

    private Class<?> beanClass;

    private PropertyValues propertyValues;

    private String initMethodName;

    private String destroyMethodName;

    private boolean singleton = true;

    private boolean prototype = false;

    private String scope = SCOPE_SINGLETON;

    public BeanDefinition(Class<?> beanClass) {
        this(beanClass, null);
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public void setScope(String scope) {
        this.scope = scope;
        singleton = SCOPE_SINGLETON.equals(scope);
        prototype = SCOPE_PROTOTYPE.equals(scope);
    }
}
