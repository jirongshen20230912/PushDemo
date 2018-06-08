package cn.sibat.pushdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageActivity extends AppCompatActivity {


    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.llayout_title)
    LinearLayout llayoutTitle;
    @BindView(R.id.rb_1)
    RadioButton rb1;
    @BindView(R.id.rb_2)
    RadioButton rb2;
    @BindView(R.id.rb_3)
    RadioButton rb3;
    @BindView(R.id.rg)
    RadioGroup rg;
    @BindView(R.id.view_infoMyCouponLine)
    TextView viewInfoMyCouponLine;// 引导线
    @BindView(R.id.vp_infoMyCoupon_file)
    public CustomViewPager vpInfoMyCouponFile;
    OrderViewPagerAdapter orderViewPagerAdapter;
    private List<Fragment> fragmentList = new ArrayList<Fragment>();

    MessageOneFragment messageOneFragment;
    MessageTwoFragment messageTwoFragment;
    MessageThreeFragment messageThreeFragment;

    public static MessageActivity messageActivity;


    /**
     * 启动该activity
     *
     * @param context 上下文环境
     */
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MessageActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        ButterKnife.bind(this);
        messageActivity = this;
        initView();
    }

    /**
     * 初始化UI
     */
    private void initView() {
        rb1.setChecked(true);
        setLine();
        messageOneFragment = new MessageOneFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("tag", 1);
        messageOneFragment.setArguments(bundle);
        fragmentList.add(messageOneFragment);

        messageTwoFragment = new MessageTwoFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putInt("tag", 2);
        messageTwoFragment.setArguments(bundle1);
        fragmentList.add(messageTwoFragment);

        messageThreeFragment = new MessageThreeFragment();
        Bundle bundle2 = new Bundle();
        bundle1.putInt("tag", 3);
        messageThreeFragment.setArguments(bundle2);
        fragmentList.add(messageThreeFragment);

        orderViewPagerAdapter = new OrderViewPagerAdapter(
                getSupportFragmentManager(), fragmentList);
        vpInfoMyCouponFile.setAdapter(orderViewPagerAdapter);
        vpInfoMyCouponFile.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                setImageWidth(index, arg0);
                index = arg0;
                if (arg0 == 0) {
                    rb1.setChecked(true);
                    return;
                }
                if (arg0 == 1){
                    rb2.setChecked(true);
                    return;
                }
                if (arg0 == 2){
                    rb3.setChecked(true);
                    return;
                }

            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }


    private Display defaultDisplay;
    private int width = 0;
    private int Linewidth = 0;
    private int new_width = 0;
    private int index = 0;
    private int scale;
    @SuppressLint("NewApi")
    public void setLine() {
        scale = (int) getResources().getDisplayMetrics().density;
        defaultDisplay = getWindowManager().getDefaultDisplay();
        Linewidth = defaultDisplay.getWidth() / 3;
        final float scale = getResources().getDisplayMetrics().density;
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                (int) (30 * scale), (int) (2 * scale));
        lp.addRule(RelativeLayout.CENTER_VERTICAL, RelativeLayout.TRUE);
        viewInfoMyCouponLine.setLayoutParams(lp);
        viewInfoMyCouponLine.setX(((Linewidth - viewInfoMyCouponLine.getWidth()) / 2)-(int) (15 * scale));
        viewInfoMyCouponLine.setBackground(getResources().getDrawable(R.drawable.shape_line_));
    }

    /**
     * 引导线
     */
    private void setImageWidth(int index, int i) {
        if (index == i) {
        } else if (index > i) {
            new_width = width;
            width += Linewidth * (i - index);
        } else {
            new_width = width;
            width += Linewidth * (i - index);
        }
        TranslateAnimation animation = new TranslateAnimation(new_width, width,
                0, 0);
        animation.setDuration(400);
        animation.setFillAfter(true);
        viewInfoMyCouponLine.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    @OnClick({R.id.iv_back, R.id.rb_1, R.id.rb_2, R.id.rb_3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.rb_1:
                setImageWidth(index, 0);
                index = 0;
                vpInfoMyCouponFile.setCurrentItem(0);
                messageOneFragment.getData();
                break;
            case R.id.rb_2:
                setImageWidth(index, 1);
                index = 1;
                vpInfoMyCouponFile.setCurrentItem(1);
                messageTwoFragment.getData();
                break;
            case R.id.rb_3:
                setImageWidth(index, 2);
                index = 2;
                vpInfoMyCouponFile.setCurrentItem(2);
                messageThreeFragment.getData();
                break;
        }
    }
}
