package requesdt.volley.com.handlerequestlib.http;

import java.util.concurrent.FutureTask;

/**
 * Created by baby on 2017/5/26.
 */

public class Volley {
    public static <T, M> void sendJSONRequest(T requestInfo, String url, Class<M> responce, IDataListener<M> dataListener) {
        IHttpListener httpListener=new JsonHttpListener(responce,dataListener);
        IHttpService httpService=new JsonHttpService();
        HttpTask<T> httpTask=new HttpTask<T>(requestInfo,url,httpService,httpListener);
        ThreadPoolManager.getInstance().execute(httpTask);
    }
}
