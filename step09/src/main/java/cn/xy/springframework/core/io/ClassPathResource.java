package cn.xy.springframework.core.io;

import cn.hutool.core.lang.Assert;
import cn.xy.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @author xiangyu
 * @date 2022-02-28 23:01
 */
public class ClassPathResource implements Resource {
    /**
     * 这里为什么要用final
     * 使用final，说明一经初始化则不允许修改，确保加载的是同一个配置对象
     */
    private final String path;
    private final ClassLoader classLoader;


    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, "Path must not be null");
        this.path = path;
        this.classLoader = classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader();

    }

    @Override
    public InputStream getInputStream() throws FileNotFoundException {
        InputStream resourceAsStream = classLoader.getResourceAsStream(path);
        if (Objects.isNull(resourceAsStream)) {
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist.");
        }
        return resourceAsStream;
    }
}
