package com.newera.okhttputils;

/**
 * @author: qndroid
 * @function: all url in the sdk
 * @date: 16/6/1
 */
public class HttpConstant {

    //代表客户端版本号
    public static final String AVS = "avs";
    //代表本次请求的会话，从reqid中取值
    public static final String SID = "sid";
    //代表本次请求的返回的素材id
    public static final String IE = "ie";
    //code代表当前step的结果码
    public static final String STEP_CD = "cd";

    //广告数据返回成功
    public static final String AD_DATA_SUCCESS = "200";
    //广告数据解析失败
    public static final String AD_DATA_FAILED = "202";
    //广告加载成功
    public static final String AD_PLAY_SUCCESS = "300";
    //广告加载失败
    public static final String AD_PLAY_FAILED = "301";

}
