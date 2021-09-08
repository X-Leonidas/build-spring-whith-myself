package cn.xy.factory;

import cn.xy.BeansException;

/**
 * @author XiangYu
 * @create2021-09-08-23:22
 */
public interface BeanFactory {
    /**
     * 获取bean
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;
}
