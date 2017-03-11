package com.example.xieyang.aty;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.demo3.R;
import com.example.xieyang.Config;
import com.example.xieyang.base.BaseActivity;
import com.example.xieyang.presenter.Register_Presenter;
import com.example.xieyang.utils.ShowLog;
import com.example.xieyang.view.Register_View;

import java.util.Random;

public class Register_Activity extends BaseActivity<Register_View,Register_Presenter>implements Register_View,View.OnClickListener{
    private TextView activity_register_cancel;
    private ImageView title_back;
    private EditText register_user,register_password,register_password_again,ar_et_verification;
    private Button bt_register;
    private LinearLayout register_verification_code;
    private ProgressDialog pd = null;

    public void init(){
//        activity_register_cancel= (TextView) findViewById(R.id.activity_register_cancel);
        register_user= (EditText) findViewById(R.id.register_user);
        register_password= (EditText) findViewById(R.id.register_password);
        register_password_again= (EditText) findViewById(R.id.register_password_again);
        register_verification_code= (LinearLayout) findViewById(R.id.register_verification_code);
        ar_et_verification= (EditText) findViewById(R.id.ar_et_verification);
        bt_register= (Button) findViewById(R.id.bt_register);
        title_back= (ImageView) findViewById(R.id.title_back);
        title_back.setOnClickListener(this);
        bt_register.setOnClickListener(this);
//        activity_register_cancel.setOnClickListener(this);
        register_verification_code.setOnClickListener(this);
        pd = new ProgressDialog(this);
        pd.setMessage("正在加载……");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
    }

//    @Override
//    public void registerSucess(int code, User data) {
//
//    }

    @Override
    public void registerSucess(int code, String data) {
        Toast.makeText(Register_Activity.this, "注册成功，请登录", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void registerFailed() {
        Toast.makeText(Register_Activity.this,"该邮箱已被注册",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void notSamePwd() {
        Toast.makeText(Register_Activity.this,"密码不一样",Toast.LENGTH_SHORT).show();
        register_password_again.setText("");
    }

    @Override
    public void nullPasswordAgain() {
        Toast.makeText(Register_Activity.this,"再次输入密码为空",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void nullValue() {
        Toast.makeText(Register_Activity.this,"别闹，请输入邮箱或密码",Toast.LENGTH_SHORT).show();
        hideLoading();
    }

    @Override
    public void failedEmail() {
        Toast.makeText(Register_Activity.this,"邮箱格式不对",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failedPasswordLength() {
        Toast.makeText(Register_Activity.this,"密码长度不对，需6到10位",Toast.LENGTH_SHORT).show();
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
        Toast.makeText(Register_Activity.this, "验证码发送成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failedcode() {
        Toast.makeText(Register_Activity.this, "验证码发送失败", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void failedLink() {
        Toast.makeText(Register_Activity.this, "服务器请求失败或者服务器异常!!!", Toast.LENGTH_SHORT).show();
    }

    @NonNull
    @Override
    public Register_Presenter createPresenter() {
        return new Register_Presenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.title_back:
                finish();
                break;
            case R.id.bt_register:
                if(ar_et_verification.getText().toString().equals(Config.Codes)){
                    pd.show();
                    getPresenter().register(register_user.getText().toString(), register_password.getText().toString(), register_password_again.getText().toString());
                }else {
                    Toast.makeText(Register_Activity.this, "验证码输入不正确", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.register_verification_code:
                Toast.makeText(Register_Activity.this,"发送验证码",Toast.LENGTH_SHORT).show();
//                String str=String.valueOf((int)(1+Math.random()*(999999-100001+1)));
                Random random = new Random();
                String str="";
                for(int i=0;i<6;i++){
                    str+=random.nextInt(10);
                }
                ShowLog.showTag("发送验证码======" + register_user.getText().toString() + str);
                Config.Codes=str;
                if(register_user.getText().toString().equals("")){
                    Toast.makeText(Register_Activity.this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
                }else {
                    pd.show();
                    getPresenter().sendCode(register_user.getText().toString(), str);
                }
                break;
        }
    }
}
