package com.example.xieyang.aty;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.demo3.MainActivity;
import com.example.administrator.demo3.R;
import com.example.xieyang.Config;
import com.example.xieyang.common.BaseActivity;
import com.example.xieyang.presenter.ForgetPassword_Presenter;
import com.example.xieyang.view.ForgetPassword_View;

import java.util.Random;

public class ForgetPassword_Activity extends BaseActivity<ForgetPassword_View, ForgetPassword_Presenter> implements ForgetPassword_View,View.OnClickListener{
    private LinearLayout forget_bt_getcode;
    private EditText forget_email,forget_code,forget_new_pwd,forget_new_pwd_again;
    private Button forget_bt_ok;
    private ProgressDialog pd = null;
    private ImageView title_back;

    public void init() {
        forget_email= (EditText) findViewById(R.id.forget_email);
        forget_code= (EditText) findViewById(R.id.forget_code);
        forget_bt_getcode= (LinearLayout) findViewById(R.id.forget_bt_getcode);
        forget_new_pwd= (EditText) findViewById(R.id.forget_new_pwd);
        forget_new_pwd_again= (EditText) findViewById(R.id.forget_new_pwd_again);
        forget_bt_ok= (Button) findViewById(R.id.forget_bt_ok);
        title_back= (ImageView) findViewById(R.id.title_back);
        title_back.setOnClickListener(this);
        forget_bt_getcode.setOnClickListener(this);
        forget_bt_ok.setOnClickListener(this);
        pd = new ProgressDialog(this);
        pd.setMessage("正在加载……");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
    }

    @NonNull
    @Override
    public ForgetPassword_Presenter createPresenter() {
        return new ForgetPassword_Presenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.forget_bt_getcode:

//                String str=String.valueOf((int)(1+Math.random()*(999999-100001+1)));
                Random random = new Random();
                String str="";
                for(int i=0;i<6;i++){
                    str+=random.nextInt(10);
                }
                Config.Codes=str;
                if(forget_email.getText().toString().equals("")){
                    Toast.makeText(ForgetPassword_Activity.this, "邮箱不能为空！！！", Toast.LENGTH_SHORT).show();
                }else{
                    pd.show();
                    getPresenter().sendCode(forget_email.getText().toString(), str);
                }
                break;
            case R.id.forget_bt_ok:
                if(forget_code.getText().toString().equals(Config.Codes)){
                    pd.show();
                    getPresenter().forgetPwd(forget_email.getText().toString(), forget_new_pwd.getText().toString(), forget_new_pwd_again.getText().toString());
                }else {
                    Toast.makeText(ForgetPassword_Activity.this, "验证码输入不正确", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.title_back:
                finish();
                break;
        }
    }

    @Override
    public void successforget() {
        Toast.makeText(ForgetPassword_Activity.this, "新密码修改成功，请登录！！！", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(ForgetPassword_Activity.this, MainActivity.class);
        startActivity(intent);
        finish();
        Login_Activity.loginActivityL.finish();
        MainActivity.mainActivityL.finish();
    }

    @Override
    public void failedforget() {
        Toast.makeText(ForgetPassword_Activity.this, "密码置换失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failedLink() {
        Toast.makeText(ForgetPassword_Activity.this, "服务器请求失败或者服务器异常!!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void notSamePwd() {
        Toast.makeText(ForgetPassword_Activity.this,"密码不一样",Toast.LENGTH_SHORT).show();
        forget_new_pwd_again.setText("");
    }

    @Override
    public void nullPasswordAgain() {
        Toast.makeText(ForgetPassword_Activity.this,"再次输入密码为空",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void nullValue() {
        Toast.makeText(ForgetPassword_Activity.this,"别闹，请输入邮箱或密码",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failedEmail() {
        Toast.makeText(ForgetPassword_Activity.this,"邮箱格式不对",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failedPasswordLength() {
        Toast.makeText(ForgetPassword_Activity.this,"密码长度不对，需6到10位",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        pd.show();
    }

    @Override
    public void hideLoading() {
        pd.cancel();
    }

    @Override
    public void successcode() {
        Toast.makeText(ForgetPassword_Activity.this, "验证码发送成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failedcode() {
        Toast.makeText(ForgetPassword_Activity.this, "验证码发送失败", Toast.LENGTH_SHORT).show();
    }
}
