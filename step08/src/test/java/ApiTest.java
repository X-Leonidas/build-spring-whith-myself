import bean.UserService;
import cn.xy.springframework.beans.factory.support.DefaultListableBeanFactory;
import cn.xy.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import cn.xy.springframework.context.support.ClassPathXmlApplicationContext;
import common.MyBeanFactoryPostProcessor;
import common.MyBeanPostProcessor;
import org.junit.Test;

/**
 * @author XiangYu
 * @create2021-09-09-0:19
 */
public class ApiTest {


    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_hook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("close！")));
    }
}
