package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author XiangYu
 * @create2021-09-08-22:52
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserService {
    private String uId;
    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId);
    }

}

