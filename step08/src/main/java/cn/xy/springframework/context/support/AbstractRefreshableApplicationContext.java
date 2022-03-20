package cn.xy.springframework.context.support;

import cn.xy.springframework.beans.BeansException;
import cn.xy.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.xy.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.xy.springframework.context.ApplicationContext;

/**
 * @author xiangyu
 * @date 2022-03-09 22:54
 *
 * Base class for {@link ApplicationContext}
 * implementations which are supposed to support multiple calls to {@link #refresh()},
 * creating a new internal bean factory instance every time.
 * Typically (but not necessarily), such a context will be driven by
 * a set of config locations to load bean definitions from.
 *
 * ApplicationContext的基类应该支持对 refresh的多次调用的实现，每次都创建一个新的内部的bean 工厂实例
 * 通常但是也不绝对的，这样的上下文将有一组用于加载bean 定义的配置
 *
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    /**
     * 加载bean定义
     * @param beanFactory
     */
    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    /**
     * 每次加载都返回私有的bean factory
     * @return
     */
    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() {
        return beanFactory;
    }
}
