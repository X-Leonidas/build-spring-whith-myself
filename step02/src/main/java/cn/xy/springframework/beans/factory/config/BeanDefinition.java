package cn.xy.springframework.beans.factory.config;

/**
 * @author XiangYu
 * @create2021-09-08-23:21
 */
public class BeanDefinition {
    private Class beanClass;


    public BeanDefinition(Class beanDefition) {
        this.beanClass = beanDefition;
    }


    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
