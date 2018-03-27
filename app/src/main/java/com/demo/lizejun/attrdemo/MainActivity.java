package com.demo.lizejun.attrdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button mButtonSwitch;
    private NightModeTextView mTvDayNight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonSwitch = (AppCompatButton) findViewById(R.id.bt_switch);
        mTvDayNight = (NightModeTextView) findViewById(R.id.tv_day_night);
        mButtonSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DayNightHelper.switchTheme(MainActivity.this);
                mTvDayNight.applyTheme(DayNightHelper.getCurTheme(MainActivity.this));
            }
        });
    }
}
