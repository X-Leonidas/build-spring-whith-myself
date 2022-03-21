package cn.xy.springframework.beans.factory;

/**
 * @author xiangyu
 * @date 2022-03-20 22:42
 * Interface to be implemented by beans that wish to be aware of their
 * owning {@link BeanFactory}.
 * 可以感知到自己这个bean的bean factory 所实现的接口
 */
public interface BeanFactoryAware extends Aware{
    void setBeanFactory(BeanFactory beanFactory);
}
