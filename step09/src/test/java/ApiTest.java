import bean.UserService;
import cn.xy.springframework.context.support.ClassPathXmlApplicationContext;
import lombok.extern.log4j.Log4j2;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

/**
 * @author XiangYu
 * @create2021-09-09-0:19
 */
@Log4j2
public class ApiTest {

    @Test
    public void test_prototype() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService01 = applicationContext.getBean("userService", UserService.class);
        UserService userService02 = applicationContext.getBean("userService", UserService.class);
        // 3. 配置 scope="prototype/singleton"
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println(userService01.hashCode());
        System.out.println(userService02.hashCode());
    }

    @Test
    public void test_factory_bean() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();
        // 2. 调用代理方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

    @Test
    public void cglibTest(){
        Enhancer enhancer = new Enhancer();
        // 设置要代理的类
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        Object o1 = enhancer.create();
        Object o2 = enhancer.create();
        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());
    }
}
