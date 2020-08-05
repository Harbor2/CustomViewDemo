package com.example.customviewdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.customviewdemo.R;
import com.example.customviewdemo.customview.CustomView;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout rv_cuntomView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initData();
    }


    private void initView() {
        rv_cuntomView = findViewById(R.id.cunstomview_parent);
    }

    private void initData(){
        CustomView customView = new CustomView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        customView.setLayoutParams(layoutParams);

        rv_cuntomView.addView(customView);
    }
}
