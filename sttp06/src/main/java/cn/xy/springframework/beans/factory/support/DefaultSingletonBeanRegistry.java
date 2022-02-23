package cn.xy.springframework.beans.factory.support;

import cn.xy.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiangyu
 * @date 2022-02-22 22:08
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
    private final Map<String, Object> singletonObject = new HashMap<>();


    @Override
    public Object getSingleton(String beanName) {
        return singletonObject.get(beanName);
    }


    protected void addSingleton(String beanName, Object bean) {
        singletonObject.put(beanName, bean);
    }
}
