package cn.xy.springframework.beans.factory.config;


import cn.xy.springframework.beans.BeansException;
import cn.xy.springframework.beans.factory.BeanFactory;

/**
 * @author xiangyu
 * @date 2022-02-28 23:22
 * Extension of the {@link BeanFactory}
 * interface to be implemented by bean factories that are capable of
 * autowiring, provided that they want to expose this functionality for
 * existing bean instances.
 *
 * {@link BeanFactory} 接口的扩展
 *  将由能够自动装配的 bean 工厂实现，前提是他们希望为现有 bean 实例公开此功能。
 *  谁实现了此接口，表明有能力自动装配bean
 * 是一个自动化处理Bean工厂配置的接口，后续逐步完善
 */
public interface AutowireCapableBeanFactory extends BeanFactory{
    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessBeforeInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行 BeanPostProcessors 接口实现类的 postProcessorsAfterInitialization 方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;
}
