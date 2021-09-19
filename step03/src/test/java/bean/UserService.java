package bean;

/**
 * @author XiangYu
 * @create2021-09-08-22:52
 */
public class UserService {
    private String name;

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append(" ").append(name);
        return sb.toString();
    }
}

