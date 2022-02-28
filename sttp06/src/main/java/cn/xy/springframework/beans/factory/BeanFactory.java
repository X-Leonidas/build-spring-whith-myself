package cn.xy.springframework.beans.factory;

import cn.xy.springframework.beans.BeansException;

/**
 * @author xiangyu
 * @date 2022-02-22 22:02
 */
public interface BeanFactory {
    Object getBean(String beanName);

    Object getBean(String beanName, Object... args);

    /**
     * 通过  requiredType 获取bean
     * @param name bean name
     * @param requiredType 要求的bean 类型
     * @param <T>
     * @return bean
     * @throws BeansException beans Exception
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
