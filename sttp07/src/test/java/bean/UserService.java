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
    private String company;
    private String location;

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
        return "UserService{" +
                "uId='" + uId + '\'' +
                ", company='" + company + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}

