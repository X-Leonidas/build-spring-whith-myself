package cn.xy.springframework.context;

/**
 * @author xiangyu
 * @date 2022-03-28 22:17
 */
public interface ApplicationEventPublisher {

    /**
     * Notify all listeners registered with this application of an application
     * event. Events may be framework events (such as RequestHandledEvent)
     * or application-specific events.
     * 通知所有使用此应用程序注册的侦听器应用程序事件。事件可以是框架事件（例如 RequestHandledEvent）或特定于应用程序的事件
     *
     * @param event the event to publish
     */
    void publishEvent(ApplicationEvent event);
}
