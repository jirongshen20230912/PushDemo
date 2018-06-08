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

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class KeLiuActivity extends AppCompatActivity {

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
    @BindView(R.id.horizontalBarChart1)
    HorizontalBarChart horizontalBarChart1;
    @BindView(R.id.horizontalBarChart2)
    HorizontalBarChart horizontalBarChart2;
    private Context context;
    public static KeLiuActivity keLiuActivity;

    /**
     * 启动该activity
     *
     * @param context 上下文环境
     */
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, KeLiuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        context.startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showMessageNum();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ke_liu);
        ButterKnife.bind(this);
        context = KeLiuActivity.this;
        keLiuActivity = this;
        showMessageNum();

        List<String> xLabels = new ArrayList<>();
        xLabels.add("深大");
        xLabels.add("白石龙");
        xLabels.add("侨城东");
        xLabels.add("车公庙");
        xLabels.add("大学城");
        MPChartUtils.configBarChart(horizontalBarChart1,xLabels,false,false);
        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        yVals1.add(new BarEntry(0, (float) 4.88));
        yVals1.add(new BarEntry(1, (float) 5.46));
        yVals1.add(new BarEntry(2, (float) 6.56));
        yVals1.add(new BarEntry(3, (float) 7.30));
        yVals1.add(new BarEntry(4, (float) 8.82));

        MPChartUtils.initBarChart(horizontalBarChart1,yVals1,"",getResources().getColor(R.color.title_gradient_end));

        List<String> xLabels1 = new ArrayList<>();
        xLabels1.add("深大");
        xLabels1.add("白石龙");
        xLabels1.add("侨城东");
        xLabels1.add("车公庙");
        xLabels1.add("大学城");
        MPChartUtils.configBarChart(horizontalBarChart2,xLabels1,false,false);
        ArrayList<BarEntry> yVals2 = new ArrayList<BarEntry>();

        yVals2.add(new BarEntry(0, (float) 4.88));
        yVals2.add(new BarEntry(1, (float) 5.46));
        yVals2.add(new BarEntry(2, (float) 6.56));
        yVals2.add(new BarEntry(3, (float) 7.30));
        yVals2.add(new BarEntry(4, (float) 8.82));

        MPChartUtils.initBarChart(horizontalBarChart2,yVals2,"",getResources().getColor(R.color.text2));


    }

    public void showMessageNum() {
        if(AppInfo.getMessageNum(context)!=0){
            frameLayoutTitleMain.setVisibility(View.VISIBLE);
            unreadMsgNumber.setText(""+AppInfo.getMessageNum(context));
        }else {
            frameLayoutTitleMain.setVisibility(View.GONE);
        }
    }

    @OnClick({R.id.iv_back, R.id.unread_msg_number, R.id.btn_container_relay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_container_relay:
                //去消息界面
                MessageActivity.actionStart(context);
                AppInfo.setMessageNum(context,0);
                break;
        }
    }
}
