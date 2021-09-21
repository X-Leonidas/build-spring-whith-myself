package cn.xy.springframework.beans.factory.support;

import cn.xy.springframework.core.io.DefaultResourceLoader;
import cn.xy.springframework.core.io.ResourceLoader;

/**
 * @author XiangYu
 * @create2021-09-21-21:06
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private BeanDefinitionRegistry registry;
    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

}
