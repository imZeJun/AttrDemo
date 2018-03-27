package com.demo.lizejun.attrdemo;


import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class AttrTextView extends AppCompatTextView {

    public AttrTextView(Context context) {
        super(context);
    }

    public AttrTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttr(context, attrs, 0);
    }

    public AttrTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttr(context, attrs, defStyleAttr);
    }

    private void initAttr(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AttrTextView, defStyleAttr, 0);
        if (typedArray != null) {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.AttrTextView);
            String text = typedArray.getString(R.styleable.AttrTextView_attr_tv_name);
            int color = typedArray.getColor(R.styleable.AttrTextView_attr_tv_color, 0);
            setText(text);
            setTextColor(color);
            typedArray.recycle();
        }
    }


}
