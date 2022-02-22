package cn.xy.springframework.beans.factory.config;

import cn.xy.springframework.beans.factory.BeanFactory;

/**
 * @author  xiangyu
 * Extension of the {@link BeanFactory}
 * interface to be implemented by bean factories that are capable of
 * autowiring, provided that they want to expose this functionality for
 * existing bean instances.
 *
 * {@link BeanFactory} 接口的扩展将由能够自动装配的 bean 工厂实现，前提是他们希望为现有 bean 实例公开此功能。
 *
 * 是一个自动化处理Bean工厂配置的接口，后续逐步完善
 */
public interface AutowireCapableBeanFactory {
}
