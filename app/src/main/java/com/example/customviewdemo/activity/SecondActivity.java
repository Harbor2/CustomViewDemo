package com.example.customviewdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.customviewdemo.R;

/**
 * @author: 王欲琢
 * @date: 2020-8-5 15:30:35
 * @desc:
 */
public class SecondActivity extends AppCompatActivity {

    private TextView tvDesc;
    private ImageView ivPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();
        initData();
    }

    private void initView() {
        tvDesc = findViewById(R.id.tv_desc);
        ivPic = findViewById(R.id.iv_pic);
    }

    private void initData() {

    }


}
