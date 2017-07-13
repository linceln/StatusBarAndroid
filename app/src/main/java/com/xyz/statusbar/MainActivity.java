package com.xyz.statusbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void turnLight(View v) {
        StatusBarUtil.setStatusBarLight(this);
    }

    public void turnDark(View v) {
        StatusBarUtil.setStatusBarDark(this);
    }

    public void turnTransparentLight(View v) {
        StatusBarUtil.setStatusBarTransparentAndLight(this);
    }

    public void turnTransparentDark(View v) {
        StatusBarUtil.setStatusBarTransparentAndDark(this);
    }
}
