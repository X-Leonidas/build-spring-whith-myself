import bean.IUserService;
import cn.xy.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;


/**
 * @author xiangyu
 * @date 2022-03-28 23:34
 */
public class ApiTest {
    @Test
    public void test_aop() {
        // TODO: 搞后置代理和一个完整的代理
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }
}
