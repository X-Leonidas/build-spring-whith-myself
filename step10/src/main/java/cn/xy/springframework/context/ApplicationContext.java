package cn.xy.springframework.context;

import cn.xy.springframework.beans.factory.HierarchicalBeanFactory;
import cn.xy.springframework.beans.factory.ListableBeanFactory;
import cn.xy.springframework.core.io.ResourceLoader;

/**
 * @author xiangyu
 * @date 2022-03-09 22:03
 * <p>
 * 应用上下文
 * Central interface to provide configuration for an application.
 * This is read-only while the application is running, but may be
 * reloaded if the implementation supports this.
 */
public interface ApplicationContext extends ListableBeanFactory , HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher{
    // TODO:为啥要继承HierarchicalBeanFactory, ResourceLoader？
}
