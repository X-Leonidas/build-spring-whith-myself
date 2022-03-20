package cn.xy.springframework.beans.factory;

/**
 * @author xiangyu
 * @date 2022-03-17 21:43
 * <p>
 * Interface to be implemented by beans that want to release resources
 * on destruction. A BeanFactory is supposed to invoke the destroy
 * method if it disposes a cached singleton. An application context
 * is supposed to dispose all of its singletons on close.
 * 由想要在销毁时释放资源的 bean 实现的接口。
 * 如果 BeanFactory 释放缓存的单例，则应该调用 destroy 方法。应用程序上下文应该在关闭时处理其所有单例。
 * 销毁接口
 */
public interface DisposableBean{
    /**
     * 销毁方法
     * @throws Exception
     */
    void destroy() throws Exception;
}
