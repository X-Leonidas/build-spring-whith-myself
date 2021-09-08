package bean;

/**
 * @author XiangYu
 * @create2021-09-08-22:52
 */
public class UserService {
    private int num = 0;

    public void queryUserInfo() {
        System.out.println("查询用户信息. num: " + num);
        num++;
    }
}
