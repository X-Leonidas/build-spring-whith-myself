package cn.xy.springframework.context;

import java.util.EventObject;

/**
 * @author xiangyu
 * @date 2022-03-28 22:11
 */
public abstract class ApplicationEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
