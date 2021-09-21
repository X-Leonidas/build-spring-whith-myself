package cn.xy.springframework.core.io;

import cn.xy.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Objects;

/**
 * @author XiangYu
 * @create2021-09-21-19:20
 */
public class ClassPathResource implements Resource {
    private String path;
    private ClassLoader classLoader;


    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
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
