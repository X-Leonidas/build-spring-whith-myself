package cn.xy.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author XiangYu
 * @create2021-09-21-19:33
 */
public class UrlResource implements Resource {

    private URL url;

    public UrlResource(URL url) {
        Assert.notNull(url, "URL must not be null");
        this.url = url;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = null;
        try {
            inputStream = urlConnection.getInputStream();
        } catch (Exception e) {
            throw e;
        } finally {
            if (urlConnection instanceof HttpURLConnection) {
                ((HttpURLConnection) urlConnection).disconnect();
            }
        }

        return inputStream;

    }
}
