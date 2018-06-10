package cn.sibat.pushdemo.serverconfig;


/**
 * Created by shenjirong on 2018/1/16.
 */

public class OkHttpConstants {

//      public static String SERVER_ADDRESSS = "http://172.20.104.91:8993";
      public static String SERVER_ADDRESSS = "http://dev.sibat.cn";
//      public static String SERVER_ADDRESSS = "http://172.20.104.138:9082";


    /**
     * 基础Url
     */
    public final static String URL1 = "/policeTraffic/api/earlyWarning/findAllEarlyWarning";
    public final static String URL2 = "/policeTraffic/api/earlyWarning/dealWith";
    public final static String URL3 = "/policeTraffic/api/earlyWarning/logList";
    public final static String CTMRURL = "/ctmr/";
    public final static String ORDRURL = "/ordr/";
    public final static String PRDTURL = "/prdt/";

    public final static String FINDURL1 = SERVER_ADDRESSS+URL1;
    public final static String FINDURL2 = SERVER_ADDRESSS+URL2;
    public final static String FINDURL3 = SERVER_ADDRESSS+URL3;

}
