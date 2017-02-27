package com.example.xieyang.aty;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.demo3.MainActivity;
import com.example.administrator.demo3.R;
import com.example.xieyang.base.BaseActivity;
import com.example.xieyang.entity.User;
import com.example.xieyang.presenter.Login_Presenter;
import com.example.xieyang.utils.ShowLog;
import com.example.xieyang.view.Login_View;

/**
 * Created by Administrator on 2016/7/23.
 */
public class Login_Activity extends BaseActivity<Login_View, Login_Presenter> implements Login_View, View.OnClickListener {

    private Button bt_login;
    private EditText login_user;
    private EditText login_password;
    private TextView tv_register,tv_forgetpw,activity_login_cancel,user_instruction;
    private ImageView title_back;

    public static Login_Activity loginActivityL=null;


    private ProgressDialog pd = null;

    public void init(){
        bt_login = (Button) findViewById(R.id.bt_login);
        login_user = (EditText) findViewById(R.id.login_user);
        login_password = (EditText) findViewById(R.id.login_password);
        tv_register = (TextView) findViewById(R.id.tv_register);
        tv_forgetpw = (TextView) findViewById(R.id.tv_forgetpw);
        title_back= (ImageView) findViewById(R.id.title_back);
        user_instruction= (TextView) findViewById(R.id.user_instruction);
        title_back.setOnClickListener(this);
//        activity_login_cancel= (TextView) findViewById(R.id.activity_login_cancel);
        bt_login.setOnClickListener(this);
        tv_register.setOnClickListener(this);
        tv_forgetpw.setOnClickListener(this);
        user_instruction.setOnClickListener(this);
//        activity_login_cancel.setOnClickListener(this);
        pd = new ProgressDialog(this);
        pd.setMessage("正在登录……");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        loginActivityL=this;
    }

    @Override
    public void cplLogin(int code, User data) {
        //登录成功后，跳到主界面<intnet>，或者回到之前的界面<finish()>，带回一个登录状态的值<token?不确定？>，使之“登录”改为“退出账号”
        SharedPreferences.Editor editor=getSharedPreferences("user",MODE_PRIVATE).edit();
        editor.putString("useraccount",data.getUserEmail());
        editor.putString("userpassword",data.getUserPassword());
        editor.putString("username",data.getUserName());
        editor.putString("usersex", data.getUserSex());
        editor.putString("userheadpicture", data.getUserHeadpicture());
        editor.putString("userbirthday", data.getUserBirthday());
        editor.putString("userconstellation", data.getUserConstellation());
        editor.putString("token", data.getToken());

        editor.commit();
        Intent intent =new Intent(Login_Activity.this, MainActivity.class);
        intent.putExtra("loginstate", "loginSuccess");
        startActivity(intent);
//        Toast.makeText(Login_Activity.this,"登录成功"+data.toString(),Toast.LENGTH_SHORT).show();
        MainActivity.mainActivityL.finish();
        finish();
        ShowLog.showTag(data.toString());
    }

    @Override
    public void fLogin() {
        Toast.makeText(Login_Activity.this,"该账号已经在别的设备登录",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failedLink() {
        Toast.makeText(Login_Activity.this, "服务器请求失败或者服务器异常!!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void successLogin() {
        Toast.makeText(Login_Activity.this, "登陆成功!!!", Toast.LENGTH_SHORT).show();
//        finish();
    }

    @Override
    public void showLoading() {
        pd.show();
    }

    @Override
    public void hideLoading() {
        pd.cancel();
    }

    @NonNull
    @Override
    public Login_Presenter createPresenter() {
        return new Login_Presenter();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:

                pd.show();
                getPresenter().login(login_user.getText().toString(), login_password.getText().toString());
                break;
            case R.id.tv_register:
                Intent intent=new Intent(Login_Activity.this,Register_Activity.class);
                startActivity(intent);
                break;
            case R.id.tv_forgetpw:
                Intent intent1=new Intent(Login_Activity.this,ForgetPassword_Activity.class);
                startActivity(intent1);
                break;
            case R.id.title_back:
                finish();
                break;
            case R.id.user_instruction:
                Intent intent2=new Intent(Login_Activity.this,UserInstruction_Activity.class);
                startActivity(intent2);
                break;
        }
    }
}
