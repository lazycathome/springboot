package cn.bigdb.hystrix;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.hystrix.HystrixCommand;

public class MyHystrixCommand extends HystrixCommand<Response> {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyHystrixCommand.class);
    private String url;

    public MyHystrixCommand(Setter setter, String url) {
        super(setter);
        this.url = url;
    }

    @Override
    protected Response run() throws Exception {
        LOGGER.info("服务正被调用，当前线程：'{}'", Thread.currentThread().getName());
        Request request = new Request.Builder().url(url).build();
        return new OkHttpClient().newCall(request).execute();
    }

    @Override
    public Response getFallback() {
        LOGGER.error("服务调用失败,service:'{}'");
        return null;
    }
}
