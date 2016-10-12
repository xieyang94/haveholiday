package com.example.xieyang.net;


import com.example.xieyang.net.api.UserService;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/5/2.
 */
public class NetWork {


    private static UserService userService;
    private static OkHttpClient okHttpClient = new OkHttpClient();
    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
    //private static String WEITAOURL = "http://121.42.205.111:80/";
    private static String WEITAOURL = "http://115.28.175.118:80/";



    public static UserService getUserService(){
        if (userService == null){

            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(WEITAOURL)
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            userService = retrofit.create(UserService.class);

        }

        return userService;
    }





}

