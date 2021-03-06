package com.malin.gson;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class VolleyUtil {

    private VolleyUtil() {
    }
    private static volatile RequestQueue requestQueue = null;

    public static RequestQueue getRequestQueue(Context context) {
        if (requestQueue == null) {
            synchronized (VolleyUtil.class) {
                if (requestQueue == null) {
                    requestQueue = Volley.newRequestQueue(context.getApplicationContext());
                }
            }
        }
        return requestQueue;
    }
}
