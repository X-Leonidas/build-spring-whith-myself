package cn.xy.springframework.beans.factory;

import cn.xy.springframework.beans.BeansException;

import java.util.Map;

/**
 * Extension of the {@link BeanFactory} interface to be implemented by bean factories
 * that can enumerate all their bean instances, rather than attempting bean lookup
 * by name one by one as requested by clients. BeanFactory implementations that
 * preload all their bean definitions (such as XML-based factories) may implement
 * this interface.
 *
 *
 *{@link BeanFactory} 接口的扩展将由可以枚举其所有 bean 实例的 bean 工厂实现，而不是按照客户端的
 * 请求通过名称一一尝试 bean 查找。 预加载所有 bean 定义的 BeanFactory 实现（例如基于 XML 的工厂）
 * 可以实现此接口。
 * <p>
 */
public interface ListableBeanFactory extends BeanFactory {
    /**
     * 按照类型返回 Bean 实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException;

    /**
     * Return the names of all beans defined in this registry.
     *
     * 返回注册表中所有的Bean名称
     */
    String[] getBeanDefinitionNames();
}
