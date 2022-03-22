package cn.xy.springframework.beans.factory;

/**
 * @author xiangyu
 * @date 2022-03-20 22:37
 * <p>
 * Callback that allows a bean to be aware of the bean
 * {@link ClassLoader class loader}; that is, the class loader used by the
 * present bean factory to load bean classes.
 * <p>
 * 允许 bean 感知到 当前bean   {@link ClassLoader class loader} 的回调，
 * 也就是当前bean工厂用来加载bean类的类加载器
 */
public interface BeanClassLoaderAware extends Aware {
    void setBeanClassLoader(ClassLoader classLoader);
}
