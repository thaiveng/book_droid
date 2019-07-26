package com.thaiveng.bookdroid.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.thaiveng.bookdroid.R;

import java.util.HashMap;

public class LogInActivity extends AppCompatActivity {
    private TextView txtRegister,txtEmail,txtPassword;
    private ProgressBar loading;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        txtRegister = findViewById(R.id.txt_register);
        loading = findViewById(R.id.loading);
        txtEmail = findViewById(R.id.edit_text_email_login);
        txtPassword = findViewById(R.id.edit_text_pwd);
        btnLogin = findViewById(R.id.btn_login);

        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
                LogInActivity.this.startActivity(intent);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//            String email = txtEmail.getText().toString().trim();
//            String pwd = txtPassword.getText().toString().trim();

//            if (!email.isEmpty() || !pwd.isEmpty()) {
//
//                HashMap data = new HashMap();
//                data.put("email", email);
//                data.put("password", pwd);
//
//                postData(urllogin, data);
//            } else {
//                txtEmail.setError("Please insert email");
//                txtPassword.setError("Please insert password");
//            }
                Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
