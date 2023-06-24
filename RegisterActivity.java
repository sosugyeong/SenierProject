package com.rec.movie;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity{
    private EditText et_id, et_pw, et_name, et_phone, et_age, et_gender;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // 액티비티 시작시 처음으로 실행되는 생명주기
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 아이디 값 찾아주기
        et_id = findViewById(R.id.et_id);
        et_pw = findViewById(R.id.et_pw);
        et_name = findViewById(R.id.et_name);
        et_phone = findViewById(R.id.et_phone);
        et_age = findViewById(R.id.et_age);
        et_gender = findViewById(R.id.et_gender);

        // 회원가입 버튼 클릭 시 수행
        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(view -> {
            // EditText에 현재 입력되어있는 값을 get해온다.
            String userID = et_id.getText().toString();
            String userPW = et_pw.getText().toString();
            String userName = et_name.getText().toString();
            String userPhone = et_phone.getText().toString();
            int userAge = Integer.parseInt(et_age.getText().toString());
            String userGender = et_gender.getText().toString();

            Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonObject = new JSONObject(response);
                        boolean success = jsonObject.getBoolean("success");
                        if(success) { //회원 가입 성공
                            Toast.makeText(getApplicationContext(),"회원가입 성공", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        } else { //회원 가입 실패
                            Toast.makeText(getApplicationContext(),"회원가입 실패", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };

            // 서버로 Volley를 이용해서 요청을 함.
            RegisterRequest registerRequest = new RegisterRequest(userID, userPW, userName, userPhone, userAge, userGender, responseListener);
            RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
            queue.add(registerRequest);

        });

    }
}
