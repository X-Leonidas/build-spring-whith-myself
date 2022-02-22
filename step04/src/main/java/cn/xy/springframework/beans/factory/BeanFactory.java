package cn.xy.springframework.beans.factory;

import cn.xy.BeansException;

/**
 * @author XiangYu
 * @date 2021-09-08-23:22
 */
public interface BeanFactory {
    /**
     * 获取bean
     *
     * @param name name
     * @return bean Object
     * @throws BeansException BeansException
     */
    Object getBean(String name) throws BeansException;


    Object getBean(String name, Object... args) throws BeansException;

}
