package cn.xy.springframework.beans.factory.support;

import cn.xy.springframework.core.io.Resource;
import cn.xy.springframework.core.io.ResourceLoader;

/**
 * @author XiangYu
 * @create2021-09-21-21:03
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource);

    void loadBeanDefinitions(Resource... resources);

    void loadBeanDefinitions(String location);
}
