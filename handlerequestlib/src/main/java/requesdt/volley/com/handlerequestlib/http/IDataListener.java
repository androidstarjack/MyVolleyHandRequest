package requesdt.volley.com.handlerequestlib.http;

/**
 * 回调调用层的接口
 */

public interface IDataListener<M>{
    void onSuccess(M m);
    void onFailure();
}
