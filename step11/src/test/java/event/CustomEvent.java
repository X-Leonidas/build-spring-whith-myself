package event;

import cn.xy.springframework.context.event.ApplicationContextEvent;
import lombok.Getter;
import lombok.Setter;

/**
 * @author xiangyu
 * @date 2022-03-28 23:32
 */
@Getter
@Setter
public class CustomEvent extends ApplicationContextEvent {

    private Long id;
    private String message;

    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public CustomEvent(Object source,Long id, String message) {
        super(source);
        this.id = id;
        this.message = message;
    }
}
