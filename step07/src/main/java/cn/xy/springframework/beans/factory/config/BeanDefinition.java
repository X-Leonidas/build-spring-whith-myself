package cn.xy.springframework.beans.factory.config;

import cn.xy.springframework.beans.PropertyValues;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiangyu
 * @date 2022-02-22 22:16
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BeanDefinition {
    private Class<?> beanClass;
    private PropertyValues propertyValues;
    private String initMethodName;
    private String destroyMethodName;

    public BeanDefinition(Class<?> beanClass) {
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }
}
