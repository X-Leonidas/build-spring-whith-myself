package cn.xy;

/**
 * @author XiangYu
 * @create 2021-09-08-22:48
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean){
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
