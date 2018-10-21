package com.example.pengcheng.frame.utils.code;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by 张鹏程 on 2017/7/7.
 *
 * 时间类
 * isDateOneBigger(); 比较两个日期的大小， 输入日期格式为 yyyy-MM-dd
 * 结果  true  前面日期 > 后面日期
 *
 *
 */

public class Time {

    /**
     * 比较两个日期的大小，日期格式为yyyy-MM-dd
     *
     * @param str1 the first date
     * @param str2 the second date
     * @return true <br/>false
     */
    public static boolean isDateOneBigger(String str1, String str2) {
        boolean isBigger = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-d");
        Date dt1 = null;
        Date dt2 = null;
        try {
            dt1 = sdf.parse(str1);
            dt2 = sdf.parse(str2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (dt1.getTime() >= dt2.getTime()) {
            isBigger = true;
        } else if (dt1.getTime() < dt2.getTime()) {
            isBigger = false;
        }
        return isBigger;
    }

    /**
     * 获得当前时间毫秒数
     * @return
     */
    public static Long getTime() {
        //获取当前时间的毫秒数
        Date date = new Date();

        Long time = date.getTime();
        return time;
    }

    /**
     * 日期格式  张鹏程
     */
    public static String dateTimeOf() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-d");
        Date date = new Date(System.currentTimeMillis());
        String time = format.format(date);

        return time;
    }

    /**
     * 日期格式+1天  张鹏程
     */
    public static String dateTimeOfNextDay() {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-M-d");
        Date date = new Date(System.currentTimeMillis());
        String time = format.format(getNextDay(date));

        return time;
    }

    /**
     * 现在时间+1天
     */
    public static Date getNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);//+1今天的时间加一天
        date = calendar.getTime();
        return date;
    }

    /**
     * 定义采集时间
     */
    public static String collectionDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String time = format.format(date);
        return time;
    }

    /**
     * 转时间格式
     *
     * @param
     * @param
     * @return
     * @throws ParseException
     */
    public static String getUSDate(String dateStr) throws ParseException {

        if (!StringUtil.objectToStr(dateStr).equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy KK:mm:ss aa", Locale.ENGLISH);
            Date date = sdf.parse(dateStr);
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.format(date);
        } else {
            return "";
        }

    }

    /**
     * 转时间格式
     *
     * @param
     * @param
     * @return
     * @throws ParseException
     */
    public static String getUSDates(String dateStr) throws ParseException {

        if (!StringUtil.objectToStr(dateStr).equals("")) {
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy KK:mm:ss aa", Locale.ENGLISH);
            Date date = sdf.parse(dateStr);
            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return sdf.format(date);
        } else {
            return "";
        }

    }

}
