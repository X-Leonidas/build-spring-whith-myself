package cn.xy.springframework.beans.factory.support;

import cn.xy.springframework.core.io.Resource;
import cn.xy.springframework.core.io.ResourceLoader;

/**
 * @author xiangyu
 * @date 2022-02-28 23:45
 */
public interface BeanDefinitionReader {
    /**
     * 获取bean definition 注册器
     * @return bean definition 注册器
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取资源加载器
     * @return resource loader
     */
    ResourceLoader getResourceLoader();

    /**
     * 通过resource 加载bean definition
     *
     * @param resource resource
     */
    void loadBeanDefinitions(Resource resource);

    /**
     * 通过resource 加载bean definition
     *
     * @param resources resource
     */
    void loadBeanDefinitions(Resource... resources);

    /**
     * 通过 location 加载bean definition
     * @param location
     */
    void loadBeanDefinitions(String location);
}
