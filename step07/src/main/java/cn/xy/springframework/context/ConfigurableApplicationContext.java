package cn.xy.springframework.context;

import cn.xy.springframework.beans.BeansException;

/**
 * @author xiangyu
 * @date 2022-03-09 22:05
 * SPI interface to be implemented by most if not all application contexts.
 * Provides facilities to configure an application context in addition
 * to the application context client methods in the
 * {@link ApplicationContext} interface.
 */
public interface ConfigurableApplicationContext extends ApplicationContext {
    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

    /**
     * 在jvm中增加一个关闭的狗子，当要关闭时调用
     */
    void registerShutdownHook();

    /**
     *  关闭的钩子中所要执行的方法
     */
    void close();
}
