package cn.xy.springframework.beans.factory.config;

/**
 * Bean 的引用
 *
 * @author XiangYu
 * @create2021-09-19-22:28
 */
public class BeanReference {
    private String beanName;


    public BeanReference() {
    }

    public BeanReference(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }
}
