package cn.xy.springframework.context;

import java.util.EventListener;

/**
 * @author xiangyu
 * @date 2022-03-28 22:16
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    /**
     * Handle an application event.
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);
}
