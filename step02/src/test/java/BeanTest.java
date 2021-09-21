import bean.UserService;
import cn.xy.springframework.beans.factory.config.BeanDefinition;
import cn.xy.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author XiangYu
 * @create2021-09-09-0:19
 */
public class BeanTest {
    @Test
    public void beanTest(){
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        defaultListableBeanFactory.registerBeanDefinition("UserService", beanDefinition);


        UserService userService = (UserService) defaultListableBeanFactory.getBean("UserService");
        userService.queryUserInfo();

        UserService userService2 = (UserService) defaultListableBeanFactory.getBean("UserService");
        userService2.queryUserInfo();
    }
}
