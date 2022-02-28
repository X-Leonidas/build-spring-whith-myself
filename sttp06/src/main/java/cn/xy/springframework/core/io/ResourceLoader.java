package cn.xy.springframework.core.io;

/**
 * @author xiangyu
 * @date 2022-02-28 23:02
 */
public interface ResourceLoader {
    String CLASSPATH_URL_PREFIX = "classpath:";
    Resource getResource(String location);
}
