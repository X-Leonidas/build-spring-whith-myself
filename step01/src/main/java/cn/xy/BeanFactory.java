package cn.xy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author XiangYu
 * @create2021-09-08-22:49
 */
public class BeanFactory {
    private Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }

    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }
}
