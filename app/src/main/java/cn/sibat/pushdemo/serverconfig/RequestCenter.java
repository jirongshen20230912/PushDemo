package cn.sibat.pushdemo.serverconfig;


import android.util.Log;

import com.newera.okhttputils.CommonOkHttpClient;
import com.newera.okhttputils.listener.DisposeDataHandle;
import com.newera.okhttputils.listener.DisposeDataListener;
import com.newera.okhttputils.listener.DisposeDownloadListener;
import com.newera.okhttputils.request.CommonRequest;
import com.newera.okhttputils.request.RequestParams;

/**
 * @author: vision
 * @function:
 * @date: 16/8/12
 */
public class RequestCenter {



    //根据参数发送所有post请求
    public static void postRequest(String url, RequestParams params, DisposeDataListener listener, Class<?> clazz) {
        CommonOkHttpClient.post(CommonRequest.
                createGetRequest(url, params), new DisposeDataHandle(listener, clazz));
    }
    public static void getRequest(String url, RequestParams params, DisposeDataListener listener) {
        Log.e("TAG","======参数======");
        Log.e("TAG",url+":"+params.urlParams.toString());
        Log.e("TAG","==============");
        CommonOkHttpClient.post(CommonRequest.
                createGetRequest(url, params), new DisposeDataHandle(listener));
    }
    public static void postRequest(String url, RequestParams params, DisposeDataListener listener) {
        Log.e("TAG","======参数======");
        Log.e("TAG",url+":"+params.urlParams.toString());
        Log.e("TAG","==============");
        CommonOkHttpClient.post(CommonRequest.
                createPostRequest(url, params), new DisposeDataHandle(listener));
    }
    public static void downloadFile(String url, RequestParams params, DisposeDownloadListener listener, String source) {
        CommonOkHttpClient.downloadFile(CommonRequest.
                createGetRequest(url, params), new DisposeDataHandle(listener,source));
    }

    /*private static void addParams(RequestParams params) {
        String sessionId = UtilsShareperferences.getSessionId(CustomApplication.getContext());
        params.put("sessionId", TextUtils.isEmpty(sessionId) ? "" : sessionId);// session
        params.put("deviceName", CustomApplication.deviceName);// 设备型号
        params.put("deviceId", CustomApplication.deviceId);// 设备ID
        params.put("platform", "1");// 设备类型：1: android 2:iphone 6: ipad
        params.put("osVersion", CustomApplication.osVersion);// 手机操作系统版本信息
        params.put("appVersion", CustomApplication.appVersion);// APP版本名称(非版本code)
        //params.put("Accept-Language", "zh-CN,zh;q=0.8");
    }*/


    /**
     * 请求任务列表
     * @param listener
     *//*
    public static void actionMissionurlall(DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        RequestCenter.getRequest(OkHttpConstants.missionurlall, params, listener);
    }
*/
    /**
     * 请求事件列表 1 2 0
     * @param listener
     */
    public static void findUrl1(String thingType,DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("thingType",thingType);
        RequestCenter.getRequest(OkHttpConstants.FINDURL1, params, listener);
    }


    /**
     * 事件处理
     * @param eventNo 事件ID 前面的id
     * @param eventType 事件类型，前面的 personAndPassenger KeyPersonEarlyWarning重点人员、STPassengerAlarmWarning商汤客流报警、APPassengerAlarmWarning  AP客流报警  必填
     * @param dealType  处理类型，1签收、2情报反馈、0完毕 必填
     * @param dealDetail 反馈内容  非必填
     * @param listener
     */
    public static void findUrl2(String eventNo,String eventType,String dealType,String dealDetail,DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("eventNo",eventNo);
        params.put("eventType",eventType);
        params.put("dealType",dealType);
        params.put("dealDetail",dealDetail);
        RequestCenter.getRequest(OkHttpConstants.FINDURL2, params, listener);
    }

    /**
     * 事件流程
     * @param eventNo 事件ID 前面的 id
     * @param eventType 事件类型，前面的 personAndPassenger  KeyPersonEarlyWarning重点人员、STPassengerAlarmWarning商汤客流报警、APPassengerAlarmWarning  AP客流报警  必填
     * @param listener
     */
    public static void findUrl3(String eventNo,String eventType,DisposeDataListener listener) {
        RequestParams params = new RequestParams();
        params.put("eventNo",eventNo);
        params.put("eventType",eventType);
        RequestCenter.getRequest(OkHttpConstants.FINDURL3, params, listener);
    }







}
