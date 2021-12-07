package cn.xy.springframework.util;

/**
 * @author XiangYu
 * @create2021-09-21-19:21
 */
public class ClassUtils {
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader contextClassLoader;
        try {
            contextClassLoader = Thread.currentThread().getContextClassLoader();
        } catch (Exception e) {
            throw new RuntimeException("Can not find default classloader");
        }

        if (contextClassLoader == null) {
            contextClassLoader = ClassUtils.getDefaultClassLoader();
        }

        return contextClassLoader;
    }
}
