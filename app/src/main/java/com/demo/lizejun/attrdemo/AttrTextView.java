package com.demo.lizejun.attrdemo;


import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import android.widget.TextView;

public class AttrTextView extends TextView {

    public AttrTextView(Context context) {
        super(context);
    }

    public AttrTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttr(context, attrs);
    }

    public AttrTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttr(context, attrs);
    }

    private void initAttr(Context context, @Nullable AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AttrTextView, R.attr.AttrThemeStyle, 0);
        if (typedArray != null) {
            String text = typedArray.getString(R.styleable.AttrTextView_attrTvName);
            int color = typedArray.getColor(R.styleable.AttrTextView_attrTvColor, 0);
            setText(text);
            setTextColor(color);
            typedArray.recycle();
        }
    }

}
