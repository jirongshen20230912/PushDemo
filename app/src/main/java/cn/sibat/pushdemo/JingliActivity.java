package cn.sibat.pushdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class JingliActivity extends AppCompatActivity {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.unread_msg_number)
    TextView unreadMsgNumber;
    @BindView(R.id.frameLayout_title_main)
    FrameLayout frameLayoutTitleMain;
    @BindView(R.id.btn_container_relay)
    RelativeLayout btnContainerRelay;
    @BindView(R.id.llayout_title)
    LinearLayout llayoutTitle;
    private  Context context;

    /**
     * 启动该activity
     *
     * @param context 上下文环境
     */
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, JingliActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jingli);
        ButterKnife.bind(this);
        context = JingliActivity.this;
    }

    @OnClick({R.id.iv_back, R.id.btn_container_relay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_container_relay:
                //跳转到消息界面
                MessageActivity.actionStart(context);
                break;
        }
    }
}
