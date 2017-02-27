package com.example.administrator.demo3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.xieyang.Config;
import com.example.xieyang.aty.Login_Activity;
import com.example.xieyang.aty.PersonInformation_Activity;
import com.example.xieyang.base.BaseActivity;
import com.example.xieyang.entity.User;
import com.example.xieyang.frags.Frag_2;
import com.example.xieyang.frags.Frag_3;
import com.example.xieyang.frags.Frag_4;
import com.example.xieyang.frags.Frag_home;
import com.example.xieyang.presenter.MainActivity_Presenter;
import com.example.xieyang.utils.GlideCircleTransform;
import com.example.xieyang.utils.SelectPicPopupWindow;
import com.example.xieyang.utils.ShowLog;
import com.example.xieyang.utils.UriTopath;
import com.example.xieyang.view.MainActivity_View;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainActivity extends BaseActivity<MainActivity_View,MainActivity_Presenter> implements MainActivity_View,OnCheckedChangeListener, OnClickListener {
    //声明相关变量
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private RadioGroup rgTabs;
    private FragmentController controller;
    private RadioButton rb_day,rb_month,rb_square,rb_tools;
    private LinearLayout user_message,bt_login;
    private TextView user_information_login,user_information;
    private static TextView user_name;
    SelectPicPopupWindow menuWindow;
    private ImageView headpicture;
    private Bitmap head;// 头像Bitmap
    private static String path = "/sdcard/myHead/";// sd路径
    private String loginState;//登录状态

    private RequestManager glideRequest;

    private UriTopath uriTopath;

    public static MainActivity mainActivityL=null;

    private long exitTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
//                Intent intentservice=new Intent(MainActivity.this, NotifyService.class);
//                intentservice.putExtra("holder",Config.HOLDER);
//                startService(intentservice);
                finish();
//                System.exit(0);
//            int pid = android.os.Process.myPid();	//获取当前应用程序的PID
//            android.os.Process.killProcess(pid);
//            ActivityManager manager = (ActivityManager)getSystemService(ACTIVITY_SERVICE); //获取应用程序管理器
//            manager.killBackgroundProcesses(getPackageName()); //强制结束当前应用程
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @NonNull
    @Override
    public MainActivity_Presenter createPresenter() {
        return new MainActivity_Presenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = new FragmentController(this, new Class[]{Frag_home.class, Frag_2
                .class, Frag_3.class, Frag_4.class}, R.id.fl_content);
        controller.showFragment(0);
        findViews(); //获取控件
        toolbar.setTitle("Toolbar");//设置Toolbar标题
        toolbar.setTitleTextColor(Color.parseColor("#ffffff")); //设置标题颜色
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        //开启服务
//        Intent intentservice=new Intent(MainActivity.this, NotifyService.class);
//        startService(intentservice);

        mainActivityL=this;

        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        initListener();

        loginState = getIntent().getStringExtra("loginstate");

        if(loginState==null||Config.USERGET==null){
            SharedPreferences pref=getSharedPreferences("user",MODE_PRIVATE);
            User user=new User();
            user.setUserEmail(pref.getString("useraccount", ""));
            user.setUserPassword(pref.getString("userpassword", null));
            user.setUserName(pref.getString("username", null));
            user.setUserSex(pref.getString("usersex", null));
            user.setUserHeadpicture(pref.getString("userheadpicture", null));
            user.setUserBirthday(pref.getString("userbirthday", null));
            user.setUserConstellation(pref.getString("userconstellation", null));
            user.setToken(pref.getString("token", null));
            Config.USERGET=user;
            if(Config.USERGET.getUserEmail().equals("")||Config.USERGET.getUserEmail()==null){
                user_message.setVisibility(View.INVISIBLE);
                user_name.setText("姓名");
            }else{
                user_name.setText(""+Config.USERGET.getUserName());
                user_information_login.setText("退出");
                user_message.setVisibility(View.VISIBLE);
            }

        }else{
            user_name.setVisibility(View.VISIBLE);
            if(Config.USERGET.getUserName()==null||Config.USERGET.getUserName().equals("")){
                user_name.setText("姓名");
            }else{
                user_name.setText(""+Config.USERGET.getUserName());
            }
            user_information_login.setText("退出");
            user_message.setVisibility(View.VISIBLE);
        }
        glideRequest = Glide.with(this);
        if(Config.USERGET==null){glideRequest.load(R.drawable.img).transform(new GlideCircleTransform(this)).into(headpicture);}
        else if(Config.USERGET.getUserHeadpicture()==null){
            glideRequest.load(R.drawable.img).transform(new GlideCircleTransform(this)).into(headpicture);
        }
        else {
            glideRequest.load(Config.USERGET.getUserHeadpicture()).transform(new GlideCircleTransform(this)).into(headpicture);
        }

    }

    private void findViews() {
        toolbar = (Toolbar) findViewById(R.id.tl_custom);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_left);
        rgTabs = (RadioGroup)findViewById(R.id.rg_tabs);
        rb_day=(RadioButton)findViewById(R.id.rb_day);
        rb_month=(RadioButton)findViewById(R.id.rb_month);
        rb_square=(RadioButton)findViewById(R.id.rb_square);
        rb_tools=(RadioButton)findViewById(R.id.rb_tools);
        user_message=(LinearLayout)findViewById(R.id.user_message);
        bt_login=(LinearLayout)findViewById(R.id.bt_login);
        user_information_login= (TextView) findViewById(R.id.user_information_login);
        user_information= (TextView) findViewById(R.id.user_information);
        user_name=(TextView)findViewById(R.id.user_name);
        headpicture= (ImageView) findViewById(R.id.head_bg);
        user_message.setOnClickListener(this);
        bt_login.setOnClickListener(this);
        headpicture.setOnClickListener(this);

       }


    protected void initListener() {
        rgTabs.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        System.out.println();
        switch (checkedId) {

            case R.id.rb_day:
                controller.showFragment(0);
                rb_day.setTextColor(Color.parseColor("#0000FF"));
                rb_month.setTextColor(Color.parseColor("#FFFFFF"));
                rb_square.setTextColor(Color.parseColor("#FFFFFF"));
                rb_tools.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case R.id.rb_month:
                controller.showFragment(1);
                rb_day.setTextColor(Color.parseColor("#FFFFFF"));
                rb_month.setTextColor(Color.parseColor("#0000FF"));
                rb_square.setTextColor(Color.parseColor("#FFFFFF"));
                rb_tools.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case R.id.rb_square:
                controller.showFragment(2);
                rb_day.setTextColor(Color.parseColor("#FFFFFF"));
                rb_month.setTextColor(Color.parseColor("#FFFFFF"));
                rb_square.setTextColor(Color.parseColor("#0000FF"));
                rb_tools.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case R.id.rb_tools:
                controller.showFragment(3);
                rb_day.setTextColor(Color.parseColor("#FFFFFF"));
                rb_month.setTextColor(Color.parseColor("#FFFFFF"));
                rb_square.setTextColor(Color.parseColor("#FFFFFF"));
                rb_tools.setTextColor(Color.parseColor("#0000FF"));
                break;

            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.user_message:
                Intent intent =new Intent(MainActivity.this, PersonInformation_Activity.class);
                startActivity(intent);
                break;
            case R.id.bt_login:
                if(loginState==null||Config.USERGET==null){
                    //退出登录
                    user_information_login.setText("登录");
                    loginState=null;
                    user_message.setVisibility(View.INVISIBLE);
                    user_name.setText("姓名");

                    Config.USERGET=null;
                    Config.SENDTIME=0;
                    glideRequest.load(R.drawable.img).transform(new GlideCircleTransform(this)).into(headpicture);
                    Intent intent1 =new Intent(MainActivity.this,Login_Activity.class);
                    startActivity(intent1);
//                    finish();
                }
                else{
                    //退出登录
                    user_information_login.setText("登录");
                    loginState=null;
                    user_message.setVisibility(View.INVISIBLE);
                    user_name.setText("姓名");

                    Toast.makeText(MainActivity.this,"退出登录",Toast.LENGTH_SHORT).show();
                    Config.USERGET=null;
                    Config.SENDTIME=0;
                    Config.DOWNLIST=10;
                    glideRequest.load(R.drawable.img).transform(new GlideCircleTransform(this)).into(headpicture);
//                    Intent intent1 =new Intent(MainActivity.this,Login_Activity.class);
//                    startActivity(intent1);
                }
                break;
            case R.id.head_bg:
                        // 实例化SelectPicPopupWindow
                        menuWindow = new SelectPicPopupWindow(MainActivity.this,itemsOnClick);
                        // 显示窗口
                        // 设置layout在PopupWindow中显示的位置
                        menuWindow.showAtLocation(MainActivity.this.findViewById(R.id.main), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
                break;
        }
    }
    // 为弹出窗口实现监听类
    private OnClickListener itemsOnClick = new OnClickListener() {

        public void onClick(View v) {
                menuWindow.dismiss();
                switch (v.getId()) {
                    case R.id.btn_take_photo:
                        Intent intent2 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        intent2.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "head.jpg")));
                        startActivityForResult(intent2, 2);// 采用ForResult打开
                        break;
                    case R.id.btn_pick_photo:
                        Intent intent1 = new Intent(Intent.ACTION_PICK, null);
                        intent1.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                        startActivityForResult(intent1, 1);
                        break;
                }
        }

    };

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    cropPhoto(data.getData());// 裁剪图片
                }
                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    File temp = new File(Environment.getExternalStorageDirectory()
                            + "/head.jpg");
                    cropPhoto(Uri.fromFile(temp));// 裁剪图片
                }
                break;
            case 3:
                if (data != null) {
                    Bundle extras = data.getExtras();
                    head = extras.getParcelable("data");
                    ShowLog.showTag("---------------------头像--------------="+head);
                    if (head != null) {

                        Uri uri = Uri.parse(MediaStore.Images.Media.insertImage(getContentResolver(), head, null, null));
                        /**
                         * 上传服务器代码
                         */
                        if(Config.USERGET==null){
                            Toast.makeText(MainActivity.this, "对不起,您还没有登录!!!", Toast.LENGTH_SHORT).show();
                        }else {
                            getPresenter().updateHeadPicture(uri, MainActivity.this, Config.USERGET.getUserEmail(), Config.USERGET.getToken());

                        }
                    }
                }
                break;
            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    };

    @Override
    public void successChangeHeadPicture(String str) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        head.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] bytes=baos.toByteArray();
        glideRequest.load(bytes).transform(new GlideCircleTransform(this)).into(headpicture);
        SharedPreferences.Editor editor=getSharedPreferences("user",MODE_PRIVATE).edit();
        editor.putString("useraccount", Config.USERGET.getUserEmail());
        editor.putString("userpassword",Config.USERGET.getUserPassword());
        editor.putString("username",Config.USERGET.getUserName());
        editor.putString("usersex", Config.USERGET.getUserSex());
        editor.putString("userheadpicture",str);
        editor.putString("userbirthday", Config.USERGET.getUserBirthday());
        editor.putString("userconstellation", Config.USERGET.getUserConstellation());
        editor.putString("token", Config.USERGET.getToken());

        editor.commit();
    }

    @Override
    public void twoUser(int code) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        head.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] bytes=baos.toByteArray();
        System.out.println("Config.headPicturecode="+Config.headPicturecode);
        if(code==404){
            Toast.makeText(MainActivity.this, "您的账号已在别的设备登录，请您重新登录!!!", Toast.LENGTH_SHORT).show();
        }else {
            glideRequest.load(bytes).transform(new GlideCircleTransform(this)).into(headpicture);
        }
    }

    /**
     * 调用系统的裁剪
     *
     * @param uri
     */
    public void cropPhoto(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 3);
    }

    private void setPicToView(Bitmap mBitmap) {
        String sdStatus = Environment.getExternalStorageState();
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
            return;
        }
        FileOutputStream b = null;
        File file = new File(path);
        file.mkdirs();// 创建文件夹
        String fileName = path + "head.jpg";// 图片名字
        try {
            b = new FileOutputStream(fileName);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭流
                b.flush();
                b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 定义一个广播接收者，用于更新UI
     */
    public static class MyBroadcastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            if(Config.USERGET==null){}
            else{
                user_name.setText(Config.USERGET.getUserName());
            }
        }
    }
}
