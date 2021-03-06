package com.example.a3projecttest7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class educationpage_home1 extends AppCompatActivity {

    private ImageView education_btn;
    private ImageView mypage_btn;
    private ImageView setting_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educationpage_home1);

        Intent service = new Intent(getApplicationContext(), MusicService.class);
        service.setPackage("com.example.a3projecttest7");
        stopService(service);
        education_btn =(ImageView)findViewById(R.id.Education);
        mypage_btn =(ImageView)findViewById(R.id.Mypage);
        setting_btn =(ImageView)findViewById(R.id.Setting);

        // 학습메뉴에서 학습버튼 눌렀을 시
        education_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(educationpage_home1.this,Education.class);
                startActivity(intent);
            }
        });
        // 학습메뉴에서 마이페이지 눌렀을 시
        mypage_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(educationpage_home1.this,Mypage.class);
                startActivity(intent);
            }
        });
        // 학습메뉴에서 셋팅 눌렀을 시
        setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(educationpage_home1.this,Setting.class);
                startActivity(intent);
            }
        });
    }
}
