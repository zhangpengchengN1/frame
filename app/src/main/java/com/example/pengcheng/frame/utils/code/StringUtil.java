package com.example.pengcheng.frame.utils.code;

public class StringUtil {

    /**
     * 返回字符串
     *
     * @param obj
     * @return
     */
    public static String objectToStr(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    /**
     * 判断b是否存在于a中，b可为多段字符串，用;号分隔
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean isIndexOfString(String a, String b) {
        a = objectToStr(a);
        b = objectToStr(b);
        if (a.indexOf(b) >= 0)
            return true;
        String s[] = b.split(";");
        for (int i = 0; i < s.length; i++) {
            if (a.indexOf(s[i]) >= 0)
                return true;
        }
        return false;
    }
}
