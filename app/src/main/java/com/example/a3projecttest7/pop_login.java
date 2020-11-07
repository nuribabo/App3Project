package com.example.a3projecttest7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

import androidx.annotation.Nullable;

public class pop_login  extends Activity {

    RequestQueue requestQueue; // 통로
    StringRequest stringRequest; // 그릇
    EditText edtext1, edtext2;
    String loginID ="";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_login);
        DisplayMetrics dm = new DisplayMetrics(); //창크기조절
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.widthPixels;
        getWindow().setLayout((int) (width * 0.5), (int) (height * 0.45));

        findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(pop_login.this, shortsentence.class));
            }
        });


    }
}

