package com.example.pengcheng.frame.utils.code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by PengchengZhang on 2017/8/21.
 * noChinese : 判断是否有汉字
 * 有一个汉字就返回true
 * isNumber : 判断是否是 纯数字
 * 有一个 不是数字的 字符就会 返回 false
 *
 * 用法 ：new NoCode().noChinese(字符串)
 *       new NoCode().isNumber(字符串);
 *
 */

public class NoCode {


    public static boolean isChinese(char c) {
        return c >= 0x4E00 && c <= 0x9FA5;// 根据字节码判断
    }

    public static boolean noChinese(String str) {
        if (str == null)
            return false;
        for (char c : str.toCharArray()) {
            if (isChinese(c))
                return true;// 有一个中文字符就返回
        }
        return false;
    }

    public static boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

}
