package cn.xy.springframework.core.io;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author XiangYu
 * @create2021-09-21-19:29
 */
@Getter
@Setter
public class FileSystemResource implements Resource {
    /**
     *  这里为什么要用final
     *     使用final，说明一经初始化则不允许修改，确保加载的是同一个配置对象
     */
    private final String path;
    private final File file;


    public FileSystemResource(String path) {
        this.path = path;
        this.file = new File(path);
    }

    public FileSystemResource(File file) {
        this.path = file.getPath();
        this.file = file;
    }

    @Override
    public InputStream getInputStream() throws FileNotFoundException {
        return  new FileInputStream(file);
    }
}
