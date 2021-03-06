package cn.xy.springframework.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author xiangyu
 * @date 2022-02-28 22:58
 */
public interface Resource {
    /**
     * 获得输入流
     * @return 输入流
     * @throws IOException IOException
     */
    InputStream getInputStream() throws IOException;
}
