package com.demo.lizejun.attrdemo;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import java.util.HashMap;

public class NightModeTextView extends AppCompatTextView implements INightMode {

    private HashMap<String, Integer> mTheme = new HashMap<>();
    private String mCurTheme = null;

    public NightModeTextView(Context context) {
        super(context);
    }

    public NightModeTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs, R.attr.dayNightAttr);
    }

    public NightModeTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        int[] dayNightResId = DayNightHelper.getDayNightStyleId(context, attrs, defStyleAttr);
        if (dayNightResId[0] != 0) {
            mTheme.put(DayNightHelper.THEME_DAY, dayNightResId[0]);
        }
        if (dayNightResId[1] != 0) {
            mTheme.put(DayNightHelper.THEME_NIGHT, dayNightResId[1]);
        }
        applyTheme(DayNightHelper.getCurTheme(context));
    }

    @Override
    public void applyTheme(String theme) {
        if (TextUtils.equals(mCurTheme, theme)) {
            return;
        }
        Integer styleId = mTheme.get(theme);
        if (styleId != null) {
            DayNightHelper.applyTextView(this, styleId);
        }
    }
}
