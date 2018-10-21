package com.example.pengcheng.frame.utils;

import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.example.pengcheng.frame.R;

/**
 * 根据 tagid 名 获得控件
 */
public class TagAndId {

    public static TextView idForIntText(String tagId, FragmentActivity activity) {
        TextView c1 = null;
        try {
            int anInt = R.id.class.getField(tagId).getInt(null);
            c1 = (TextView) activity.findViewById(anInt);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return c1;
    }
}
