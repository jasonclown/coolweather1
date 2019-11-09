package com.coolweather.android;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MyTest {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.baidu.com").build();
        try {
            Response response=client.newCall(request).execute();
            if(response.isSuccessful()){
                System.out.println("success");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("send fail");
        }
        System.out.println("fail");
    }
}
