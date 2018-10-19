package com.example.pengcheng.frame.network.moudle;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.pengcheng.frame.network.api.BaseRetrofit;
import com.example.pengcheng.frame.network.server.TestImpl;
import com.google.gson.JsonObject;

import org.json.JSONException;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * model 对数据进行封装
 * 首先在activity中用结构时，要先 引用接口 implements OnResponse，然后分以下两部
 * 1、在activity中进行使用时，先定义private TestModel testModel
 * 2、其次在实例化，和监听model返回值  TestModel = new TestModel(this);  testModel.setListener(this);
 * 3、在复写的success中，根据requestCode 是条件写个switch，o 是具体的数值结果
 */
public class TestModel extends BaseMoudle {

    public static final int CODE_POST_LOGIN = 1;

    TestImpl test;

    public TestModel(Context context) {
        super(context);
        test = BaseRetrofit.getInstance().getMyServer(TestImpl.class);
    }

    public TestModel(Activity context) {
        super(context);
    }

    public TestModel(Fragment fragment) {
        super(fragment);
    }

    public void getUserInfo(String loginName, String pwd) {
        subscribe = test.sendLoginResult(loginName, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<JsonObject>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Exception exception = (Exception) e;
                        onResponse.fail(CODE_POST_LOGIN, exception);
                    }

                    @Override
                    public void onNext(JsonObject jsonObject) {
                        try {
                            onResponse.success(CODE_POST_LOGIN, "", jsonObject);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
