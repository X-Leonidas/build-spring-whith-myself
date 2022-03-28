package cn.xy.springframework.context.event;

import cn.xy.springframework.beans.factory.BeanFactory;
import cn.xy.springframework.context.ApplicationEvent;
import cn.xy.springframework.context.ApplicationListener;

/**
 * @author xiangyu
 * @date 2022-03-28 23:13
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {


    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
