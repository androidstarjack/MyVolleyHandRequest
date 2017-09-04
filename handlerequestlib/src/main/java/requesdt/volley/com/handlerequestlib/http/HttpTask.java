package requesdt.volley.com.handlerequestlib.http;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;

/**
 * Created by baby on 2017/5/26.
 */

public class HttpTask<T> implements Runnable {

    private IHttpService httpService;
    private IHttpListener httpListener;

    protected  <T> HttpTask(T requestInfo, String url, IHttpService httpService,IHttpListener httpListener) {
        this.httpService=httpService;
	    this.httpListener=httpListener;
        httpService.setUrl(url);
        //设置关系
        httpService.setHttpCallBack(httpListener);
        //设置请求参数
        if (requestInfo != null) {
            String requestContent=  JSON.toJSONString(requestInfo);
            try {
                this.httpService.setRequestData(requestContent.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run() {
        //执行网络请求
        httpService.excute();
    }

}
