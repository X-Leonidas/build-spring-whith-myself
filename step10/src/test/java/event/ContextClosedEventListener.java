package event;

import cn.xy.springframework.context.ApplicationListener;
import cn.xy.springframework.context.event.ContextClosedEvent;
import lombok.extern.log4j.Log4j2;

/**
 * @author xiangyu
 * @date 2022-03-28 23:29
 */
@Log4j2
public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        log.info("关闭事件：" + this.getClass().getName());
    }
}
