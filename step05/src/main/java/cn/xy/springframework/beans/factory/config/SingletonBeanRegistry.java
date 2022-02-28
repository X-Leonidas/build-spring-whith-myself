package cn.xy.springframework.beans.factory.config;

/**
 * @author XiangYu
 * @date 2021-09-08-23:22
 *
 * bean 注册接口
 */
public interface SingletonBeanRegistry {
    /**
     * 获取bean定义对象
     * @param beanName beanName
     * @return bean
     */
    Object getSingleton(String beanName);
}
