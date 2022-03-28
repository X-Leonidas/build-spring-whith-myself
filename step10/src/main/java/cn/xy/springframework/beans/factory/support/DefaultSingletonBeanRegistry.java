package cn.xy.springframework.beans.factory.support;

import cn.xy.springframework.beans.BeansException;
import cn.xy.springframework.beans.factory.DisposableBean;
import cn.xy.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author xiangyu
 * @date 2022-02-22 22:08
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /**
     * Internal marker for a null singleton object:
     * used as marker value for concurrent Maps (which don't support null values).
     * <p>
     * <p>
     * 空的单例对象的内部标记：用作并发 Maps 的标记值（不支持空值）。
     */
    protected static final Object NULL_OBJECT = new Object();

    private final Map<String, Object> singletonObjects = new HashMap<>();

    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    protected void addSingleton(String beanName, Object bean) {
        singletonObjects.put(beanName, bean);
    }

    /**
     * 继承的是子类AbstractBeanFactory中实现的ConfigurableBeanFactory接口中所定义的方法，是一种不错的隔离分层设计模式
     */
    public void destroySingletons() {
        Set<String> keySet = this.disposableBeans.keySet();
        Object[] disposableBeanNames = keySet.toArray();

        for (int i = disposableBeanNames.length - 1; i >= 0; i--) {
            Object disposableBeanName = disposableBeanNames[i];
            DisposableBean disposableBean = disposableBeans.remove(disposableBeanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + disposableBeanName + "' threw an exception", e);
            }
        }
    }
}
