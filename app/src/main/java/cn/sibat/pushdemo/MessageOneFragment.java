package cn.sibat.pushdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.newera.okhttputils.listener.DisposeDataListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.sibat.pushdemo.bean.Base64Util;
import cn.sibat.pushdemo.bean.JsonUtils;
import cn.sibat.pushdemo.bean.StringUtil;
import cn.sibat.pushdemo.bean.StyleData;
import cn.sibat.pushdemo.bean.UrlDataList;
import cn.sibat.pushdemo.serverconfig.BaseFragment;
import cn.sibat.pushdemo.serverconfig.RequestCenter;

/**
 * @author 沈吉荣
 */
public class MessageOneFragment extends BaseFragment {
    @BindView(R.id.listView)
    ListView listView;
    Unbinder unbinder;
    private Context context;
    List<StyleData> messageItemList = new ArrayList<>();
    CommonAdapter<StyleData>  messageItemCommonAdapter;


    @Override
    public void onStart() {
        super.onStart();
        getData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        context = getActivity();
        unbinder = ButterKnife.bind(this, view);
        initData();
        Bitmap bmp= BitmapFactory.decodeResource(getResources(), R.mipmap.img_main_9);
        Log.i("TAG",Base64Util.bitmapToBase64(bmp));
        return view;
    }

    private void initData() {
        messageItemCommonAdapter = new CommonAdapter<StyleData>(context,messageItemList,R.layout.item_lv_one) {
            @Override
            public void convert(CommonViewHolder helper, final StyleData item) {
                if("感知门".equals(item.getDeviceType())){
                    helper.setImageResource(R.id.iv_deviceType,R.mipmap.img_main_11);
                    helper.setViewVisibility(R.id.iv_user1,View.VISIBLE);
                    helper.setViewVisibility(R.id.iv_user2,View.VISIBLE);
                    helper.setViewVisibility(R.id.iv_user3,View.GONE);
                    helper.setImageBitmap(R.id.iv_user1, Base64Util.base64ToBitmap(item.getReserve2()));
                    helper.setImageBitmap(R.id.iv_user2, Base64Util.base64ToBitmap(item.getReserve3()));
                }else if("AP".equals(item.getDeviceType())){
                    helper.setImageResource(R.id.iv_deviceType,R.mipmap.img_main_14);
                    helper.setViewVisibility(R.id.iv_user1,View.VISIBLE);
                    helper.setViewVisibility(R.id.iv_user2,View.GONE);
                    helper.setViewVisibility(R.id.iv_user3,View.GONE);
                    helper.setImageBitmap(R.id.iv_user1, Base64Util.base64ToBitmap(item.getReserve2()));
                }else if("WIFI".equals(item.getDeviceType())){
                    helper.setImageResource(R.id.iv_deviceType,R.mipmap.img_main_32);
                    helper.setViewVisibility(R.id.iv_user1,View.VISIBLE);
                    helper.setViewVisibility(R.id.iv_user2,View.GONE);
                    helper.setViewVisibility(R.id.iv_user3,View.GONE);
                    helper.setImageBitmap(R.id.iv_user1, Base64Util.base64ToBitmap(item.getReserve2()));
                }else if("深圳通".equals(item.getDeviceType())){
                    helper.setImageResource(R.id.iv_deviceType,R.mipmap.img_main_31);
                    helper.setViewVisibility(R.id.iv_user1,View.VISIBLE);
                    helper.setViewVisibility(R.id.iv_user2,View.GONE);
                    helper.setViewVisibility(R.id.iv_user3,View.GONE);
                    helper.setImageBitmap(R.id.iv_user1, Base64Util.base64ToBitmap(item.getReserve2()));
                }else if("电子围栏".equals(item.getDeviceType())){
                    helper.setImageResource(R.id.iv_deviceType,R.mipmap.img_main_10);
                    helper.setViewVisibility(R.id.iv_user1,View.VISIBLE);
                    helper.setViewVisibility(R.id.iv_user2,View.GONE);
                    helper.setViewVisibility(R.id.iv_user3,View.GONE);
                    helper.setImageBitmap(R.id.iv_user1, Base64Util.base64ToBitmap(item.getReserve2()));
                }else if("人脸识别".equals(item.getDeviceType())){
                    helper.setImageResource(R.id.iv_deviceType,R.mipmap.img_main_27);
                    helper.setViewVisibility(R.id.iv_user2,View.VISIBLE);
                    helper.setImageBitmap(R.id.iv_user1, Base64Util.base64ToBitmap(item.getReserve2()));
                    helper.setImageBitmap(R.id.iv_user2, Base64Util.base64ToBitmap(item.getReserve3()));
                }else {
                    helper.setImageResource(R.id.iv_deviceType,R.mipmap.img_main_25);
                    helper.setViewVisibility(R.id.iv_user1,View.GONE);
                    helper.setViewVisibility(R.id.iv_user2,View.GONE);
                    helper.setViewVisibility(R.id.iv_user3,View.VISIBLE);
                    helper.setImageUrl(R.id.iv_user3,context,item.getImagePath());
                }
                if(!TextUtils.isEmpty(item.getDeviceType())){
                    helper.setViewVisibility(R.id.layout_deviceType1,View.VISIBLE);
                    helper.setViewVisibility(R.id.layout_deviceType2,View.GONE);
                    helper.setViewVisibility(R.id.layout_deviceType3,View.GONE);
                }else if("stAlarm".equals(item.getDataSources())){
                    helper.setViewVisibility(R.id.layout_deviceType1,View.GONE);
                    helper.setViewVisibility(R.id.layout_deviceType2,View.VISIBLE);
                    helper.setViewVisibility(R.id.layout_deviceType3,View.GONE);
                }else {
                    helper.setViewVisibility(R.id.layout_deviceType1,View.GONE);
                    helper.setViewVisibility(R.id.layout_deviceType2,View.GONE);
                    helper.setViewVisibility(R.id.layout_deviceType3,View.VISIBLE);
                }

                helper.setText(R.id.tv_createTime, StringUtil.toEmpty(item.getCreateTime()));
                helper.setText(R.id.tv_deviceAddress,StringUtil.toEmpty(item.getDeviceAddress()));
                helper.setText(R.id.tv_keypersonState,"预警类别："+StringUtil.toEmpty(item.getKeypersonState()));
                helper.setText(R.id.tv_keypersonType,"人员类别："+StringUtil.toEmpty(item.getKeypersonType()));
                helper.setText(R.id.tv_compareSources,"比中信息："+StringUtil.toEmpty(item.getCompareSources()));
                helper.setText(R.id.tv_keypersonId,StringUtil.toEmpty(item.getKeypersonId()));
                helper.setText(R.id.tv_eventType,"事件类型："+StringUtil.toEmpty(item.getEventType()));
                helper.setText(R.id.tv_crowdNumber,"事件相关人数/总人数："+StringUtil.toEmpty(item.getCrowdNumberWithEvent())+"/"+StringUtil.toEmpty(item.getCrowdNumberAllImage()));
                helper.setText(R.id.tv_chaosDesity,"混乱程度："+(StringUtil.toEmpty(item.getChaosDesity()).equals("0")?"混乱":"严重混乱"));
                helper.setText(R.id.tv_crowdDesity,"过密程度："+(StringUtil.toEmpty(item.getCrowdDesity()).equals("0")?"过密":"严重过密"));

                helper.setClickListener(R.id.tv_submit, new CommonViewHolder.MyClickListener() {
                    @Override
                    public void onClick(View v) {
                        super.onClick(v);
                        new AlertDialog(mContext)
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
                                        LoadingDialogShow("");
                                        RequestCenter.findUrl2(item.getId(), item.getPersonAndPassenger(), "1", "", new DisposeDataListener() {
                                            @Override
                                            public void onSuccess(Object responseObj) {
                                                LoadingDialogDismiss();
                                                getData();
                                                MessageActivity.messageActivity.vpInfoMyCouponFile.setCurrentItem(1);
                                                MessageTwoFragment.messageTwoFragment.getData();
                                            }

                                            @Override
                                            public void onFailure(Object reasonObj) {
                                                LoadingDialogDismiss();
                                            }
                                        });

                                    }
                                })
                                .show();
                    }
                });
            }
        };
        listView.setAdapter(messageItemCommonAdapter);
        messageItemCommonAdapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //去消息详情页面
                MessageDetailActivity.actionStart(context,messageItemList.get(position).getId(),messageItemList.get(position).getPersonAndPassenger());
            }
        });
    }

    /**
     * 获取数据
     */
    public void getData() {
        LoadingDialogShow("");
        RequestCenter.findUrl1("1", new DisposeDataListener() {
            @Override
            public void onSuccess(Object responseObj) {
                LoadingDialogDismiss();
                String result = responseObj.toString();
                UrlDataList bean = JsonUtils.jsonObject(UrlDataList.class, result);
                if (bean != null) {
                    if(messageItemList!=null&&messageItemList.size()!=0){
                        messageItemList.clear();
                    }
                    messageItemList.addAll(bean.getData());
                    messageItemCommonAdapter.notifyDataSetChanged();
                } else {
                    CustomToast.showToast(getActivity(), "数据请求失败", 1000);
                }
            }

            @Override
            public void onFailure(Object reasonObj) {
                LoadingDialogDismiss();
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
