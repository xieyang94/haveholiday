package com.example.xieyang.aty;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.demo3.R;
import com.example.xieyang.Config;
import com.example.xieyang.base.BaseActivity;
import com.example.xieyang.entity.User;
import com.example.xieyang.presenter.PersonInformation_Presenter;
import com.example.xieyang.utils.PopWindow_pf_sex;
import com.example.xieyang.view.PersonInformation_View;

import org.greenrobot.eventbus.EventBus;

import java.util.Calendar;

public class PersonInformation_Activity extends BaseActivity<PersonInformation_View,PersonInformation_Presenter> implements PersonInformation_View,View.OnClickListener {
    private LinearLayout person_information_save;
    private TextView person_information_edit,person_information_sex;
    private ImageView title_back;
    private TextView person_information_account,person_information_birthday,person_information_constellation;
    private EditText person_information_name;
    private User user;
    PopWindow_pf_sex menuWindow;
    private ProgressDialog pd = null;
    public void init() {
        person_information_edit = (TextView) findViewById(R.id.person_information_edit);
        person_information_sex = (TextView) findViewById(R.id.person_information_sex);
        person_information_account = (TextView) findViewById(R.id.person_information_account);
        person_information_constellation = (TextView) findViewById(R.id.person_information_constellation);
        person_information_name = (EditText) findViewById(R.id.person_information_name);
        person_information_birthday = (TextView) findViewById(R.id.person_information_birthday);
        title_back = (ImageView) findViewById(R.id.title_back);
        person_information_save = (LinearLayout) findViewById(R.id.person_information_save);
        person_information_edit.setOnClickListener(this);
        person_information_sex.setOnClickListener(this);
        person_information_birthday.setOnClickListener(this);
        title_back.setOnClickListener(this);
        person_information_save.setOnClickListener(this);
        person_information_name.setSelection(person_information_name.length());//将光标移至文字末尾
        pd = new ProgressDialog(this);
        pd.setMessage("正在保存个人信息……");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_information);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        init();
        showGet();
        person_information_save.setVisibility(View.INVISIBLE);

    }
    //个人信息界面显示个人信息
    public void showGet(){
        if(Config.USERGET.getUserEmail()==null){
            person_information_account.setText("");
        }
        else{
            person_information_account.setText(""+Config.USERGET.getUserEmail());
        }
        if(Config.USERGET.getUserName()==null){
            person_information_name.setText("");
        }else{
            person_information_name.setText(""+Config.USERGET.getUserName());

        }
        if(Config.USERGET.getUserSex()==null){
            person_information_sex.setText("");
        }else{
            person_information_sex.setText("" + Config.USERGET.getUserSex());
        }
        if(Config.USERGET.getUserBirthday()==null){
            person_information_birthday.setText("");
        }else{
            person_information_birthday.setText(""+Config.USERGET.getUserBirthday());
        }
        if(Config.USERGET.getUserConstellation()==null){
            person_information_constellation.setText("");
        }else{
            person_information_constellation.setText(""+Config.USERGET.getUserConstellation());
        }

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.person_information_edit:
                setEnabled();
                person_information_save.setVisibility(View.VISIBLE);
//                showToast("编辑");
//                Toast.makeText(PersonInformation_Activity.this, "编辑", Toast.LENGTH_LONG).show();
                break;
            case R.id.person_information_sex:
                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                //隐藏键盘
                person_information_sex.setInputType(InputType.TYPE_NULL);
                // 实例化SelectPicPopupWindow
                menuWindow = new PopWindow_pf_sex(PersonInformation_Activity.this, itemsOnClick);
                // 显示窗口
                menuWindow.showAtLocation(
                        PersonInformation_Activity.this.findViewById(R.id.main),
                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0); // 设置layout在PopupWindow中显示的位置
                break;
            case R.id.person_information_birthday:
                //获取当前时间
                int now_year;
                int now_month;
                int now_day;
                Calendar c = Calendar.getInstance();
                now_year = c.get(Calendar.YEAR);
                now_month = c.get(Calendar.MONTH);
                now_day = c.get(Calendar.DAY_OF_MONTH);

                new DatePickerDialog(PersonInformation_Activity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        person_information_birthday.setText("" + String.format("%04d-%02d-%02d", year,monthOfYear+1,dayOfMonth));
                        String str=""+String.format("%04d-%02d-%02d",year,monthOfYear+1,dayOfMonth);
                        person_information_constellation.setText(constellation((monthOfYear+1),dayOfMonth));
                    }
                },now_year,now_month,now_day).show();

                break;
            case R.id.title_back:
                finish();
                break;
            case R.id.person_information_save:

                SharedPreferences.Editor editor=getSharedPreferences("user",MODE_PRIVATE).edit();
                editor.putString("useraccount",person_information_account.getText().toString());
                editor.putString("username",person_information_name.getText().toString());
                editor.putString("usersex",person_information_sex.getText().toString());
                editor.putString("userbirthday",person_information_birthday.getText().toString());
                editor.putString("userconstellation",person_information_constellation.getText().toString());
                editor.putString("token",Config.USERGET.getToken());

                editor.commit();

                pd.show();
                getPresenter().save(person_information_account.getText().toString(), person_information_name.getText().toString(), person_information_sex.getText().toString(), person_information_birthday.getText().toString(), person_information_constellation.getText().toString(), Config.USERGET.getToken());

                setUnEnabled();
                break;
        }

    }
    public void setEnabled(){
        person_information_sex.setEnabled(true);
        person_information_account.setEnabled(true);
        person_information_name.setEnabled(true);
        person_information_birthday.setEnabled(true);
    }
    public void setUnEnabled(){
        person_information_sex.setEnabled(false);
        person_information_account.setEnabled(false);
        person_information_name.setEnabled(false);
        person_information_birthday.setEnabled(false);
    }
    // 为弹出窗口实现监听类
    private OnClickListener itemsOnClick = new OnClickListener() {

        public void onClick(View v) {
            menuWindow.dismiss();
            switch (v.getId()) {
                case R.id.person_information_sex_boy:
                    person_information_sex.setText("男");
                    break;
                case R.id.person_information_sex_girl:
                    person_information_sex.setText("女");
                    break;
                default:
                    break;
            }
        }

    };

    @NonNull
    @Override
    public PersonInformation_Presenter createPresenter() {
        return new PersonInformation_Presenter();
    }

    @Override
    public void successUpdate(User user) {
        person_information_save.setVisibility(View.INVISIBLE);
        Toast.makeText(PersonInformation_Activity.this, "个人信息修改成功", Toast.LENGTH_SHORT).show();
        /**
         * 发送一个广播，通知MainActivity的侧滑菜单更新UI
         */
//        Intent intent=new Intent();
//        intent.setAction("com.xieyang.xieyang");
//        sendBroadcast(intent);
        EventBus.getDefault().post(user);
    }


    @Override
    public void twoUser() {
        Toast.makeText(PersonInformation_Activity.this, "你的账号已在别的设备登录,请重新登录", Toast.LENGTH_SHORT).show();
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
    public void failedLink() {
        Toast.makeText(PersonInformation_Activity.this, "服务器请求失败或者服务器异常!!!", Toast.LENGTH_SHORT).show();
    }

    //星座Constellation
    public String constellation(int month,int day){
        String[] astro = new String[] { "摩羯座", "水瓶座", "双鱼座", "白羊座", "金牛座",
                "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };
        int[] arr = new int[] { 20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22 };// 两个星座分割日
        int index = month;
        // 所查询日期在分割日之前，索引-1，否则不变
        if (day < arr[month - 1]) {
            index = index - 1;
        }
        // 返回索引指向的星座string
        return astro[index];
    }

}
