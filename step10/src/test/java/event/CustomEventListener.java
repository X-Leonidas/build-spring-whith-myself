package event;

import cn.xy.springframework.context.ApplicationListener;
import lombok.extern.log4j.Log4j2;

import java.util.Date;

/**
 * @author xiangyu
 * @date 2022-03-28 23:33
 */
@Log4j2
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        log.info("收到：" + event.getSource() + "消息;时间：" + new Date());
        log.info("消息：" + event.getId() + ":" + event.getMessage());
    }
}
