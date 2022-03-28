package cn.xy.springframework.context.event;

import cn.xy.springframework.context.ApplicationEvent;
import cn.xy.springframework.context.ApplicationListener;

/**
 * @author xiangyu
 * @date 2022-03-28 22:27
 */
public interface ApplicationEventMulticaster {
    /**
     * Add a listener to be notified of all events.
     * @param applicationListener the listener to add
     */
    void addApplicationListener(ApplicationListener<?> applicationListener);

    /**
     * Remove a listener from the notification list.
     * @param applicationListener the listener to remove
     */
    void removeApplicationListener(ApplicationListener<?> applicationListener);

    /**
     * Multicast the given application event to appropriate listeners.
     * @param applicationEvent the event to multicast
     */
    void multicastEvent(ApplicationEvent applicationEvent);
}
