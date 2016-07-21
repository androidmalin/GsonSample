package com.malin.gson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//http://www.linfuyan.com/how-to-install-apache-tomcat7-on-ubuntu-14-04-via-apt-get/
//http://wiki.ubuntu.org.cn/Tomcat

//http://stormzhang.com/android/2014/05/22/android-gson/
//http://blog.csdn.net/lk_blog/article/details/7685169

//http://blog.csdn.net/u011439289/article/details/17529215

// sudo /etc/init.d/tomcat7 start
// sudo /etc/init.d/tomcat7 stop
// cd /var/lib/tomcat7/webapps


// sudo vim /var/lib/tomcat7/webapps/malin/db.json
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "HHHHHHKLLLL";
    private RequestQueue mRequestQueue;
    private static final String URL = "http://192.168.1.115:8080/malin/db.json";
    private static final String URL_3 = "http://192.168.1.115:8080/malin/dog.json";
    private static final String URL_4 = "http://192.168.1.115:8080/malin/animation.json";
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.init("MALIN");
        mTextView = (TextView) findViewById(R.id.tv_result);
        mRequestQueue = VolleyUtil.getRequestQueue(getApplicationContext());

        funcation1();


    }

    private void funcation1() {
        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    Logger.t(TAG).json(response.toString());

                    // json转为简单Bean
                    Person person = new Gson().fromJson(response, Person.class);
                    mTextView.setText(person.toString());

                    // 简单的bean转为json
                    String json = new Gson().toJson(person);
                    Logger.t(TAG).json(json);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        request.setTag(this);
        mRequestQueue.add(request);
    }


    private void funcation2() {
        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    Logger.t(TAG).json(response.toString());

                    GsonBuilder gsonBuilder = new GsonBuilder();
                    gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss");
                    Gson gson = gsonBuilder.create();
                    Cat cat = gson.fromJson(response, Cat.class);
                    mTextView.setText(cat.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        request.setTag(this);
        mRequestQueue.add(request);
    }

    private void funcation3() {
        StringRequest request = new StringRequest(URL_3, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    Logger.t(TAG).json(response.toString());
                    Dog dog = new Gson().fromJson(response, Dog.class);
                    mTextView.setText(dog.toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        request.setTag(this);
        mRequestQueue.add(request);
    }

    private void funcation4() {
        StringRequest request = new StringRequest(URL_4, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    Logger.t(TAG).json(response.toString());
                    Animation[] animationsArray = new Gson().fromJson(response, Animation[].class);
                    List<Animation> list = Arrays.asList(animationsArray);
                    mTextView.setText(list.get(0).toString() + list.get(1).toString());
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        request.setTag(this);
        mRequestQueue.add(request);
    }

    private void funcation5() {
        StringRequest request = new StringRequest(URL_4, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    Logger.t(TAG).json(response.toString());

                    // json转为带泛型的list
                    List<Animation> list = new Gson()
                            .fromJson(response, new TypeToken<List<Animation>>() {}
                                    .getType());
                    for (Animation animation:list){
                        Logger.t(TAG).d(animation.toString());
                    }
                    mTextView.setText(list.get(0).toString() + list.get(1).toString());
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        request.setTag(this);
        mRequestQueue.add(request);
    }

}
