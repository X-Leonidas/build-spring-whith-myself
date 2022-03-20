package cn.xy.springframework.beans;

/**
 * @author xiangyu
 * @date 2022-02-22 21:41
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
