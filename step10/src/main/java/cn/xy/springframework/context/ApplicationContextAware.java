package cn.xy.springframework.context;

import cn.xy.springframework.beans.factory.Aware;

/**
 * @author xiangyu
 * @date 2022-03-20 22:44
 * <p>
 * Interface to be implemented by any object that wishes to be notified
 * of the {@link ApplicationContext} that it runs in.
 *
 * 实现此接口，可以让bean感知到自己的application context
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext);
}
