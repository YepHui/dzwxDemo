package com.example.dzwxdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.dzwxdemo.util.StringUtils;

public class RegisterActivity extends BaseActivity {

    private Boolean checkFlag = false;
    private Toolbar toolbar;
    private EditText phone;
    private Button sendCaptcha;
    private EditText captcha;
    private EditText password;
    private EditText confirmPassword;
    private TextView userAgreement;
    private Button register;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        init();
        initToolbar(toolbar);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if (validateForm()) {
                    Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                    startActivity(intent);
                }*/
                Intent intent = new Intent(RegisterActivity.this, AuthIdentityActivity.class);
                startActivity(intent);
            }
        });

        TextUtils.getBuilder().click(getResources().getString(R.string.company_partner_protocol), getResources().getColor(R.color.theme_color), new TextUtils.OnClickListener() {
            @Override
            public void onClick(int position) {
                switch (position) {
                    case 0:
                        //跳转链接
                        Intent intent = new Intent(RegisterActivity.this, UserAgreementActivity.class);
                        startActivity(intent);
                        break;

                }
            }
        }, "《达知网校隐私政策》").checkBox(this, userAgreement, new TextUtils.OnImageClickListener() {
            @Override
            public void onChecked() {
                register.setTextColor(getResources().getColor(R.color.black));
                checkFlag = true;
            }

            @Override
            public void onUnChecked() {
                register.setTextColor(getResources().getColor(R.color.light_grey));
                checkFlag = false;
            }
        }).clickInto(userAgreement);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private Boolean validateForm() {
        String phoneNum = phone.getText().toString().trim();
        String captchaNum = captcha.getText().toString().trim();
        String pwd = password.getText().toString().trim();
        String confirmPwd = confirmPassword.getText().toString().trim();
        if (StringUtils.isBlank(phoneNum)) {
            Toast toast = Toast.makeText(RegisterActivity.this, "请输入手机号", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return false;
        } else if (StringUtils.isBlank(captchaNum)) {
            Toast toast = Toast.makeText(RegisterActivity.this, "请输入验证码", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return false;
        } else if (StringUtils.isBlank(pwd)) {
            Toast toast = Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return false;
        } else if (StringUtils.isBlank(confirmPwd)) {
            Toast toast = Toast.makeText(RegisterActivity.this, "请确认密码", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return false;
        } else if (!checkFlag) {
            Toast toast = Toast.makeText(RegisterActivity.this, "请先勾选同意《达知网校隐私政策》", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            return false;
        }
        return true;
    }

    @Override
    protected void init() {
        toolbar = findViewById(R.id.t_r_title);
        phone = findViewById(R.id.et_r_phone);
        sendCaptcha = findViewById(R.id.btn_send_captcha);
        captcha = findViewById(R.id.et_r_captcha);
        password = findViewById(R.id.et_r_pwd);
        confirmPassword = findViewById(R.id.et_r_confirm_pwd);
        userAgreement = findViewById(R.id.tv_user_agreement);
        register = findViewById(R.id.btn_register);
        back = findViewById(R.id.btn_r_back);
    }
}
