package common;



import cn.xy.springframework.beans.BeansException;
import cn.xy.springframework.beans.PropertyValue;
import cn.xy.springframework.beans.PropertyValues;
import cn.xy.springframework.beans.factory.config.BeanDefinition;
import lombok.extern.log4j.Log4j2;
import cn.xy.springframework.beans.factory.ConfigurableListableBeanFactory;
import cn.xy.springframework.beans.factory.config.BeanFactoryPostProcessor;

@Log4j2
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        log.info("开始执行bean factory增强");
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();

        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }

}
