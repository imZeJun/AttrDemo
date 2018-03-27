package com.demo.lizejun.attrdemo;

import android.util.Log;

public class ReflectHelper {

    private static final String TAG = ReflectHelper.class.getSimpleName();

    public static class Styleable {

        private static final Class<?> CLASS_STYLEABLE = getStyleableClass();

        public static int[] sTextView;
        public static int sTextViewSize;
        public static int sTextViewColor;
        public static int sText;

        static {

            try {
                sTextView = (int[]) CLASS_STYLEABLE.getField("TextView").get(null);
            } catch (Exception e) {
                Log.w(TAG, "", e);
            }

            try {
                sTextViewSize = CLASS_STYLEABLE.getField("TextView_textSize").getInt(null);
            } catch (Exception e) {
                Log.w(TAG, "", e);
            }

            try {
                sTextViewColor = CLASS_STYLEABLE.getField("TextView_textColor").getInt(null);
            } catch (Exception e) {
                Log.w(TAG, "", e);
            }

            try {
                sText = CLASS_STYLEABLE.getField("TextView_text").getInt(null);
            } catch (Exception e) {
                Log.w(TAG, "", e);
            }
        }

        private static Class<?> getStyleableClass() {
            try {
                Class<?> clz = Class.forName("com.android.internal.R$styleable");
                return clz;
            } catch (Exception e) {
                Log.w(TAG, "", e);
            }
            return null;
        }
    }
}
