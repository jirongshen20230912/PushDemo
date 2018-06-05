package cn.sibat.pushdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.btn_login)
    Button btnLogin;

    private Context context;
    //账号密码字符串
    private String userloginID, userPassString;
    /**
     * 启动该activity
     *
     * @param context 上下文环境
     */
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        context = LoginActivity.this;
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                MainActivity.actionStart(context);
                finish();
                /*if (checkContent()) {
                    if("admin".equals(userloginID)&&"123456".equals(userPassString)){
                        MainActivity.actionStart(context);
                        finish();
                    }else {
                        CustomToast.showToast(context, "用户名或密码错误", 1000);
                    }
                }*/
                break;
        }
    }

    /**
     * @return true表示输入项校验通过 false表示输入项校验不通过
     */
    private boolean checkContent() {
        userloginID = username.getText().toString().trim();
        userPassString = password.getText().toString().trim();
        if (!NetUtils.isConnection(context)) {
            CustomToast.showToast(context, "网络不可用", 1000);
            return false;
        }

        //校验登录账号是否为空
        if (TextUtils.isEmpty(userloginID)) {
            CustomToast.showToast(context, "用户名不能为空", 1000);
            username.requestFocus();
            return false;
        }
        //校验登录密码是否为空
        if (TextUtils.isEmpty(userPassString)) {
            CustomToast.showToast(context, "密码不能为空", 1000);
            password.requestFocus();
            return false;
        }
        return true;
    }
}
