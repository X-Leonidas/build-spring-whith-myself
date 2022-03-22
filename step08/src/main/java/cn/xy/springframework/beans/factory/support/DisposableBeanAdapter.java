package cn.xy.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import cn.xy.springframework.beans.factory.DisposableBean;
import cn.xy.springframework.beans.factory.config.BeanDefinition;
import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Method;

/**
 * @author xiangyu
 * @date 2022-03-17 22:38
 * Adapter that implements the {@link DisposableBean} and {@link Runnable} interfaces
 * performing various destruction steps on a given bean instance:
 */
@Log4j2
public class DisposableBeanAdapter implements DisposableBean {
    private final Object bean;
    private final String beanName;
    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }


    @Override
    public void destroy() throws Exception{
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }


        if (StrUtil.isNotEmpty(destroyMethodName)
                && !(bean instanceof DisposableBean)
                && "destroyDataMethod".equals(this.destroyMethodName)) {
            try {
                Method initMethod = bean.getClass().getMethod(destroyMethodName);
                initMethod.invoke(bean);
            } catch (Exception e) {
                log.error("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
        }
    }
}
