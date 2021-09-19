package cn.xy.factory.config;

/**
 * @author XiangYu
 * @create2021-09-08-23:22
 */
public interface SingletonBeanRegistry {
    /**
     * 获取bean定义对象
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);
}
