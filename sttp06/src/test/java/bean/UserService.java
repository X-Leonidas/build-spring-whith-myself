package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author XiangYu
 * @date 2021-09-08-22:52
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserService {
    private String uId;
    private UserDao userDao;

    public void queryUserInfo() {
        String userName = userDao.queryUserName(uId);
        if (Objects.nonNull(userName) && userName.length() > 0) {
            System.out.println("查询用户信息：" + userDao.queryUserName(uId));
        } else {
            System.out.println("query user name failed.");
        }


    }

}

