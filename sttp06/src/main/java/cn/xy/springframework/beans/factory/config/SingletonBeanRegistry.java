package cn.xy.springframework.beans.factory.config;

/**
 * @author xiangyu
 * @date 2022-02-22 22:06
 */
public interface SingletonBeanRegistry {
    /**
     * 获取bean定义对象
     *
     * @param beanName beanName
     * @return bean Object
     */
    Object getSingleton(String beanName);
}
