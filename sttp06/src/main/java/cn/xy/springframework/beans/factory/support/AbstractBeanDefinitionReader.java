package cn.xy.springframework.beans.factory.support;

import cn.xy.springframework.core.io.DefaultResourceLoader;
import cn.xy.springframework.core.io.ResourceLoader;

/**
 * @author xiangyu
 * @date 2022-02-28 23:49
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {
    private final BeanDefinitionRegistry beanDefinitionRegistry;
    private final ResourceLoader resourceLoader;

    public AbstractBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry, ResourceLoader resourceLoader) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
        this.resourceLoader = resourceLoader;
    }

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        this(beanDefinitionRegistry, new DefaultResourceLoader());
    }


    @Override
    public BeanDefinitionRegistry getRegistry() {
        return beanDefinitionRegistry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
