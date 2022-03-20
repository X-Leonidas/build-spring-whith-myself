package cn.xy.springframework.context.support;

import cn.xy.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.xy.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author xiangyu
 * @date 2022-03-09 23:09
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
