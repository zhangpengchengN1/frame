package com.example.pengcheng.frame.utils.view.time;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.pengcheng.frame.utils.code.StringUtil;
import com.example.pengcheng.frame.utils.code.Time;
import com.example.pengcheng.frame.utils.hint.ToastUtil;

import java.util.Calendar;

/**
 * 时间控件显示
 */
public class ShowTime {

    public void showCalendar(final TextView textView, final Context context) {

        final String currT = Time.dateTimeOf();//当前时间
        final Time time = new Time();
        textView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub
                if (hasFocus) {
                    Calendar c = Calendar.getInstance();
                    DatePickerDialog datePickerDialog =
                            new DatePickerDialog(context,
                                    android.R.style.Theme_Holo_Light_Dialog_NoActionBar,
                                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                            // TODO Auto-generated method stub
                            String startT = StringUtil.objectToStr(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);//选择时间
                            boolean currAsStart = time.isDateOneBigger(currT, startT);//比较当前时间和选择时间
                            if (currAsStart) {
                                ToastUtil.showShort(context, "选择的时间不能比当前时间早");
                            } else {
                                textView.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                            }
                        }
                    }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
                    datePickerDialog.setCancelable(false);//点击空白处不会关闭
                    datePickerDialog.show();//显示
                }
            }
        });
    }

}
