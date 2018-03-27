package com.demo.lizejun.attrdemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

public class DayNightHelper {

    public static final String SP_NAME = "sp";
    public static final String DAY_NIGHT_THEME_KEY = "theme_day_night";
    public static final String THEME_DAY = "theme_day";
    public static final String THEME_NIGHT = "theme_night";

    public static int[] getDayNightStyleId(Context context, @Nullable AttributeSet attrs, int defStyle) {
        int dayStyleId = 0;
        int nightStyleId = 0;
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ThemeCommonStyleable, defStyle, 0);
        if (a != null) {
            int dayNightStyleId = a.getResourceId(R.styleable.ThemeCommonStyleable_dayNightAttr, 0);
            if (dayNightStyleId != 0) {
                TypedArray dayNightArray = context.getTheme().obtainStyledAttributes(dayNightStyleId, R.styleable.DayNightStyleable);
                if (dayNightArray != null) {
                    dayStyleId = dayNightArray.getResourceId(R.styleable.DayNightStyleable_themeDayAttr, 0);
                    nightStyleId = dayNightArray.getResourceId(R.styleable.DayNightStyleable_themeNightAttr, 0);
                    dayNightArray.recycle();
                }
            }
            a.recycle();
        }
        return new int[]{ dayStyleId, nightStyleId };
    }

    public static void applyTextView(TextView textView, int styleId) {
        TypedArray a = textView.getContext().getTheme().obtainStyledAttributes(styleId,
                ReflectHelper.Styleable.sTextView);
        if (a != null) {
            int indexCount = a.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int attr = a.getIndex(i);
                if (attr == ReflectHelper.Styleable.sTextViewSize) {
                    int textSize = a.getDimensionPixelSize(attr, 0);
                    if (textSize != 0) {
                        textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
                    }
                } else if (attr == ReflectHelper.Styleable.sTextViewColor) {
                    ColorStateList textColor = a.getColorStateList(attr);
                    textView.setTextColor(textColor);
                } else if (attr == ReflectHelper.Styleable.sText) {
                    String text = a.getString(attr);
                    textView.setText(text);
                }
            }
            a.recycle();
        }
    }

    public static String getCurTheme(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        return sp.getString(DAY_NIGHT_THEME_KEY, THEME_DAY);
    }

    public static void switchTheme(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        String curTheme = sp.getString(DAY_NIGHT_THEME_KEY, THEME_DAY);
        String nextTheme;
        if (TextUtils.equals(curTheme, THEME_DAY)) {
            nextTheme = THEME_NIGHT;
        } else {
            nextTheme = THEME_DAY;
        }
        sp.edit().putString(DAY_NIGHT_THEME_KEY, nextTheme).apply();
    }
}
