package requesdt.volley.com.myvolleyhandrequest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import requesdt.volley.com.handlerequestlib.RequestData;
import requesdt.volley.com.handlerequestlib.ResponceData;
import requesdt.volley.com.handlerequestlib.http.IDataListener;
import requesdt.volley.com.handlerequestlib.http.Volley;

public class MainActivity extends AppCompatActivity {

    String url="http://v.juhe.cn/sweizhang/citys";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view){

        Volley.sendJSONRequest(new RequestData("jett", "123"), url, ResponceData.class, new IDataListener<ResponceData>() {
            @Override
            public void onSuccess(ResponceData responceData) {
                Toast.makeText(MainActivity.this,responceData.toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure() {
                Log.i("TAG","onFailure()");
            }
        });
    }
}
