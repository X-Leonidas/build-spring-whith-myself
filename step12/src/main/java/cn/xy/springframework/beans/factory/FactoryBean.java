package cn.xy.springframework.beans.factory;

/**
 * @author xiangyu
 * @date 2022-03-22 21:46
 * interface to be implemented by objects used within a {@link BeanFactory}
 * which are themselves factories. if a bean implements this interface,
 * it is used as a factory for an object to expose, not directly as a bean
 * instance that will be exposed itself.
 *
 * 由 {@link BeanFactory} 中使用的对象实现的接口，这些对象本身就是工厂。
 * 如果一个 bean 实现了这个接口，它被用作一个对象的工厂来暴露，而不是直接作为一个 bean 实例来暴露自己。
 *
 *
 *
 */
public interface FactoryBean<T> {
    /**
     * 这个bean factory 创建bean的能力
     * @return bean
     * @throws Exception exception
     */
    T getObject() throws Exception;

    /**
     * 返回bean 的 class 类型
     * @return bean 的 class 类型
     */
    Class<?> getObjectType();

    /**
     * 判断是否为单例
     * @return 是否为单例
     */
    boolean isSingleton();
}
