package cn.sibat.pushdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MessageDetailActivity extends AppCompatActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.llayout_title)
    LinearLayout llayoutTitle;
    @BindView(R.id.tv_messageId)
    TextView tvMessageId;
    @BindView(R.id.tv_messageTime)
    TextView tvMessageTime;
    @BindView(R.id.tv_messageDetail)
    TextView tvMessageDetail;
    @BindView(R.id.tv_qianshou)
    TextView tvQianshou;
    @BindView(R.id.tv_qingbao)
    TextView tvQingbao;
    @BindView(R.id.tv_jieshu)
    TextView tvJieshu;
    @BindView(R.id.myListView)
    MyListView myListView;

    private Context context;

    List<MessageDetail> messageDetailList = new ArrayList<>();
    CommonAdapter<MessageDetail>  messageDetailCommonAdapter;

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    /**
     * 启动该activity
     *
     * @param context 上下文环境
     */
    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MessageDetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_detial);
        ButterKnife.bind(this);
        context = MessageDetailActivity.this;
        initData();
    }

    private void initData() {
        messageDetailList.add(new MessageDetail("2018-8-2 12:23:03","已评价","张三（099321）福田派出所","0",0));
        messageDetailList.add(new MessageDetail("2018-8-2 12:23:03","处置完毕","张三（099321）福田派出所","0",1));
        messageDetailList.add(new MessageDetail("2018-8-2 12:23:03","消息反馈","张三（099321）福田派出所","1",2));
        messageDetailList.add(new MessageDetail("2018-8-2 12:23:03","处置中","","0",3));
        messageDetailList.add(new MessageDetail("2018-8-2 12:23:03","已签收","张三（099321）福田派出所","0",4));
        messageDetailList.add(new MessageDetail("2018-8-2 12:23:03","已下发","张三（099321）福田派出所","0",5));
        messageDetailList.add(new MessageDetail("2018-8-2 12:23:03","已审核","张三（099321）福田派出所","0",6));
        messageDetailCommonAdapter = new CommonAdapter<MessageDetail>(context,messageDetailList,R.layout.item_lv_detail) {
            @Override
            public void convert(CommonViewHolder helper, MessageDetail item) {
                helper.setText(R.id.tv_detail_time,item.getDetail_time());
                if(item.getIndex()==0){
                    helper.setViewVisibility(R.id.tv_detail_icon_up,View.INVISIBLE);
                }else{
                    helper.setViewVisibility(R.id.tv_detail_icon_up,View.VISIBLE);
                }
                if(item.getIndex()==messageDetailList.size()-1){
                    helper.setViewVisibility(R.id.tv_detail_icon_down,View.INVISIBLE);
                }else {
                    helper.setViewVisibility(R.id.tv_detail_icon_down,View.VISIBLE);
                }

                helper.setText(R.id.tv_detail_message,item.getDetail_message());
                if("".equals(item.getDetail_user())){
                    helper.setViewVisibility(R.id.tv_detail_user,View.GONE);
                }else {
                    helper.setViewVisibility(R.id.tv_detail_user,View.VISIBLE);
                    helper.setText(R.id.tv_detail_user,item.getDetail_user());
                }
                if("0".equals(item.getDetail_iv())){
                    helper.setViewVisibility(R.id.iv_message,View.GONE);
                }else {
                    helper.setViewVisibility(R.id.iv_message,View.VISIBLE);
                }
                helper.setClickListener(R.id.iv_message, new CommonViewHolder.MyClickListener() {
                    @Override
                    public void onClick(View v) {
                        super.onClick(v);
                        new AlertDialog(context)
                                .builder()
                                .setTitle("消息反馈")
                                .setMsg("消息反馈详情内容...\n"+"消息反馈信息...")
                                .setNegativeButton("关闭", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {

                                    }
                                })
                                .show();
                    }
                });
            }
        };
        myListView.setAdapter(messageDetailCommonAdapter);
        messageDetailCommonAdapter.notifyDataSetChanged();
    }

    @OnClick({R.id.iv_back, R.id.tv_messageId, R.id.tv_messageTime, R.id.tv_messageDetail, R.id.tv_qianshou, R.id.tv_qingbao, R.id.tv_jieshu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.tv_qianshou:
                new AlertDialog(context)
                        .builder()
                        .setMsg("签收本条消息")
                        .setNegativeButton("取消", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        })
                        .setPositiveButton("签收", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //调用签收接口

                            }
                        })
                        .show();
                break;
            case R.id.tv_qingbao:
                new AlertDialog(context)
                        .builder()
                        .showEdit()
                        .setTitle("情报反馈")
                        .setNegativeButton("取消", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        })
                        .setPositiveButton("提交", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //调用情报反馈接口

                            }
                        })
                        .show();
                break;
            case R.id.tv_jieshu:
                new AlertDialog(context)
                        .builder()
                        .setMsg("是否提交结束处置？")
                        .setNegativeButton("取消", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        })
                        .setPositiveButton("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //调用结束处置接口

                            }
                        })
                        .show();
                break;
        }
    }

    /**
     * 获取数据
     */
    public void getData() {

    }
}
