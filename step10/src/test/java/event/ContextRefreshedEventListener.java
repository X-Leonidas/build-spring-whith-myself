package event;

import cn.xy.springframework.context.ApplicationListener;
import cn.xy.springframework.context.event.ContextRefreshedEvent;
import lombok.extern.log4j.Log4j2;

/**
 * @author xiangyu
 * @date 2022-03-28 23:31
 */
@Log4j2
public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
       log.info("刷新事件：" + this.getClass().getName());
    }
}
