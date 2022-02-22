package cn.xy;

/**
 * @author XiangYu
 * @date 2021-09-08-23:22
 * <p>
 * bean definition exception
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
