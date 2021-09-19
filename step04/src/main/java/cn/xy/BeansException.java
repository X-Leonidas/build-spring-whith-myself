package cn.xy;

/**
 * @author XiangYu
 * @create2021-09-08-23:22
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
