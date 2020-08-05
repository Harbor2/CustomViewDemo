package com.example.textpiclibary;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

/**
 * @author: 王欲琢
 * @date: 2020-8-5 15:30:35
 * @desc:
 */
public class SecondActivity extends AppCompatActivity {

    private TextView tvDesc;
    private ImageView ivPic;
    private Button btnChange;
    private EditText etPutText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();
        initData();
        initListener();
    }

    private void initView() {
        tvDesc = findViewById(R.id.tv_desc);
        ivPic = findViewById(R.id.iv_pic);
        etPutText = findViewById(R.id.et_input);
        btnChange = findViewById(R.id.btn_change);



    }



    private void initListener() {
        btnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = etPutText.getText().toString().trim();
                if (text != null && !TextUtils.isEmpty(text)){
                    tvDesc.setText(text+"");
                }
            }
        });
    }


    private void initData() {
        Intent intent = getIntent();
        String picUrl = intent.getStringExtra("picUrl");
        //展示图片
        if (picUrl != null && !TextUtils.isEmpty(picUrl)){
            Glide.with(SecondActivity.this)
                    .load(picUrl)
                    .apply(new RequestOptions().error(R.drawable.animal))
                    .into(ivPic);
        }


    }


}
