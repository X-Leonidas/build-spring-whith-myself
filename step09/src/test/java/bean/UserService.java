package bean;

import cn.xy.springframework.beans.factory.DisposableBean;
import cn.xy.springframework.beans.factory.InitializingBean;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

/**
 * @author XiangYu
 * @date 2021-09-08-22:52
 */

@Data
@Log4j2
public class UserService implements InitializingBean, DisposableBean {
    private String uId;
    private IUserDao userDao;
    private String company;
    private String location;

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
    public int hashCode() {
        return super.hashCode();
    }
}

