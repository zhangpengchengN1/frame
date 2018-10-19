package com.example.pengcheng.frame.network.server;

import com.google.gson.JsonObject;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

public interface TestImpl {

    @FormUrlEncoded
    @POST("login.do")
    //实体类或者jsonobject
    Observable<JsonObject> sendLoginResult(@Field("loginname")String loginname, @Field("password")String password);
}
