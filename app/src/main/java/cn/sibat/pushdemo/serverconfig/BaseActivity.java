package cn.sibat.pushdemo.serverconfig;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.sibat.pushdemo.R;

public class BaseActivity extends AppCompatActivity{
    private Context mContext ;
    private Dialog loadingDialog;
    private TextView tipTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = BaseActivity.this;
    }

    /**
     * @方法说明 加载中dialog（show（））
     */
    public void LoadingDialogShow(String msg) {
        if (loadingDialog == null) {
            LayoutInflater inflater = LayoutInflater.from(this);
            View v = inflater.inflate(R.layout.loading_dialog, null);// 得到加载view
            LinearLayout layout = (LinearLayout) v
                    .findViewById(R.id.dialog_view);// 加载布局
            // main.xml中的ImageView
            // ImageView spaceshipImage = (ImageView) v.findViewById(R.id.img);
            tipTextView = (TextView) v.findViewById(R.id.tipTextView);// 提示文字
            // // 加载动画
            // Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(
            // this, R.anim.loading_animation);
            // // 使用ImageView显示动画
            // spaceshipImage.startAnimation(hyperspaceJumpAnimation);
            tipTextView.setText(msg);// 设置加载信息

            loadingDialog = new Dialog(this, R.style.loading_dialog);// 创建自定义样式dialog
            loadingDialog.setCanceledOnTouchOutside(false);
            loadingDialog.setCancelable(false);// 不可以用“返回键”取消
            loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT));// 设置布局

        }
        try {
            if (loadingDialog != null && !loadingDialog.isShowing()) {
                tipTextView.setText(msg);
                loadingDialog.show();
            }
        } catch (Exception e) {

        }
    }

    /**
     * @方法说明 diamiss————dialog
     */
    public void LoadingDialogDismiss() {

        if (loadingDialog != null && loadingDialog.isShowing()) {
            try {
                loadingDialog.dismiss();
                loadingDialog = null;
            } catch (Exception e) {

            }
        }
    }
}
