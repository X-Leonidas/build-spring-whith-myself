package cn.xy.springframework.beans.factory;

/**
 * @author xiangyu
 * @date 2022-02-22 22:02
 */
public interface BeanFactory {
    Object getBean(String beanName);

    Object getBean(String beanName, Object... args);
}
