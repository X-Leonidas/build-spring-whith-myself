import cn.xy.springframework.context.support.ClassPathXmlApplicationContext;
import event.CustomEvent;
import org.junit.Test;

/**
 * @author xiangyu
 * @date 2022-03-28 23:34
 */
public class ApiTest {
    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }
}
