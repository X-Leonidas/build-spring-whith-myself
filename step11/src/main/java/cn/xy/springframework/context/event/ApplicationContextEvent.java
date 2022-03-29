package cn.xy.springframework.context.event;

import cn.xy.springframework.context.ApplicationContext;
import cn.xy.springframework.context.ApplicationEvent;

/**
 * @author xiangyu
 * @date 2022-03-28 22:13
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }


    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext) getSource();
    }
}
