package cn.xy.springframework.beans.factory.config;

/**
 * @author xiangyu
 * @date 2022-02-22 22:06
 *
 * 获取bean注册的
 */
public interface SingletonBeanRegistry {
    /**
     * 获取bean定义对象
     *
     * @param beanName beanName
     * @return bean Object
     */
    Object getSingleton(String beanName);

    /**
     * 注册单例bean对象
     * @param beanName
     * @param singletonObject
     */
    void registerSingleton(String beanName, Object singletonObject);
}
