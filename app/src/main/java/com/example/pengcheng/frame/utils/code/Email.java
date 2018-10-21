package com.example.pengcheng.frame.utils.code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 张鹏程 on 2017/7/12.
 * 判断 是否是邮箱  是否是正确的手机格式
 * 用法
 * isEmail()==true  邮箱格式正确
 * isMobile()==true  手机号格式正确
 */

public class Email {

    //     邮箱
    public static boolean isEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);

        return m.matches();
    }

    //判断手机格式是否正确
    public static boolean isMobile(String mobiles) {
        Pattern p = Pattern
                .compile("^((10[0-9])|(19[0-9])|(16[0-9])|(14[0-9])|(12[0-9])|(11[0-9])|(17[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);

        return m.matches();
    }
}
