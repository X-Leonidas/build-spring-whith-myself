package bean;

import cn.xy.springframework.beans.factory.*;
import cn.xy.springframework.context.ApplicationContext;
import cn.xy.springframework.context.ApplicationContextAware;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

/**
 * @author XiangYu
 * @date 2021-09-08-22:52
 */

@Data
@Log4j2
@NoArgsConstructor
@AllArgsConstructor
public class UserService implements InitializingBean, DisposableBean, BeanNameAware, BeanClassLoaderAware, ApplicationContextAware, BeanFactoryAware {
    private String uId;
    private UserDao userDao;
    private String company;
    private String location;

    private BeanFactory beanFactory;

    private ApplicationContext applicationContext;

    @Override
    public void destroy() throws Exception {
        log.info("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("执行：UserService.afterPropertiesSet");
    }

    public String queryUserInfo() {
        String userName = userDao.queryUserName(uId);
        if (Objects.nonNull(userName) && userName.length() > 0) {
            System.out.println(this);
            return userDao.queryUserName(uId);
        } else {
            throw new RuntimeException("query user name failed.");
        }
    }


    @Override
    public String toString() {
        return "UserService{" + "uId='" + uId + '\'' + ", company='" + company + '\'' + ", location='" + location + '\'' + '}';
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        log.info("classLoader: " + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        log.info("Bean factory: " + beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        log.info("Bean name: " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        log.info("application context: " + applicationContext);
    }
}

