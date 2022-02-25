package cn.xy.springframework.util;

/**
 * @author xiangyu
 * @date 2022-02-25 22:52
 */
public class ClassUtils {
    public static ClassLoader getDefaultClassLoader() {
        ClassLoader classLoader = null;
        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (Exception e) {
            // Cannot access thread context ClassLoader - falling back to system class loader...
        }

        if (classLoader == null) {
            classLoader = ClassUtils.class.getClassLoader();

        }
        return classLoader;

    }


}
