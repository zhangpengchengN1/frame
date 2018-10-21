package com.example.pengcheng.frame.utils.code;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;

import com.example.pengcheng.frame.R;


/**
 * Created by PengchengZhang on 2017/9/15.
 * 验证码
 * 1、在activity 中对 bound Timer 进行实例化
 * 2、对 实例化的 bound Timer进行 .start();
 * 3、参数含义：text view 控件，context 上下文 ，millisInFuture 时间时长 ，countDownInterval 时间倒数的间隔
 */

public class BoundTimer extends CountDownTimer {

    private int colorSetting;
    private TextView codeSetting;

    public BoundTimer(TextView codeSetting, Context context, long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
        this.codeSetting = codeSetting;
        colorSetting = context.getResources().getColor(R.color.colorS);
    }

    @Override
    public void onTick(long l) {
        codeSetting.setClickable(false);
        codeSetting.setTextColor(colorSetting);
        codeSetting.setText("重新发送(" + l / 1000 + ")");
    }

    @Override
    public void onFinish() {
        codeSetting.setClickable(true);
        codeSetting.setTextColor(colorSetting);
        codeSetting.setText("获取验证码");
    }
}
