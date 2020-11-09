package com.example.a3projecttest7;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class pop_join extends Activity {
    RequestQueue requestQueue; // 통로
    StringRequest stringRequest; // 그릇
    EditText edtext3, edtext4, edtext5, edtext6;
    String loginID =""; //?

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // 팝업창 조절
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pop_join);
        DisplayMetrics dm = new DisplayMetrics(); //창크기조절
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.widthPixels;
        getWindow().setLayout((int) (width * 0.5), (int) (height * 0.45));

//        // 회원가입 완료 버튼
//        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

        // 데이터 이동
        // 1. requestQueue세팅!
        requestQueue = Volley.newRequestQueue(pop_join.this);

        // 2. url세팅
        String url = "http://localhost:8077/kid/JoinServlet";

        // 3. stringRequest세팅
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            // 데이터 응답 리스너
            public void onResponse(String response) {
                if(response.equals("1")){
                    Toast.makeText(getApplicationContext(), "회원가입성공!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(pop_join.this, Education.class));
                finish();
                }else{
                    Toast.makeText(getApplicationContext(), "아이디를 확인하세요", Toast.LENGTH_SHORT).show();
                }
            }
            // 데이터 에러 리스너
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("volleyerror", error.toString());
            }
        }){
            //stringRequest클래스내의 값을 전송하는 메소드 오버라이딩

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> joinData = new HashMap<String, String>();
                joinData.put("id", edtext5.getText().toString());
                joinData.put("pw", edtext6.getText().toString());
                joinData.put("name", edtext3.getText().toString());
                joinData.put("nickname", edtext4.getText().toString());

                return joinData;
            }
        };

        // 4. stringRequest에 tag달기
        stringRequest.setTag("join");

        // 5. requestQueue에 StringRequest전송하기!
        findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestQueue.add(stringRequest);
            }
        });
    }
}
