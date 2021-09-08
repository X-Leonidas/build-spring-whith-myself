import bean.UserService;
import cn.xy.BeanDefinition;
import cn.xy.BeanFactory;
import org.junit.Test;

/**
 * @author XiangYu
 * @create2021-09-08-22:53
 */


public class BeanTest {
    @Test
    public void beanFactoryTest() {
        BeanFactory beanFactory = new BeanFactory();

        beanFactory.registerBeanDefinition("UserService", new BeanDefinition(new UserService()));

        UserService userService = (UserService) beanFactory.getBean("UserService");
        userService.queryUserInfo();

    }

}
