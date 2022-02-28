package cn.xy.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author xiangyu
 * @date 2022-02-28 23:03
 */
public class FileSystemResource implements Resource {
    private String path;
    private File file;

    FileSystemResource(File file) {
        this.path = file.getPath();
        this.file = file;
    }

    FileSystemResource(String path) {
        this.file = new File(path);

    }


    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(file);
    }
}
