package cn.sibat.pushdemo.bean;

public class StatusListData {
//    "id": 13,   //主键
//            "dealType": "STPassengerAlarmWarning",  //事件类型
//            "relateId": 2667309,  //关联ID
//            "dealStatus": "5",  //处置状态
//            "createTime": 1528443555000, //创建事件
//            "dealDetail": "处置测试",  //处置详情
//            "dealUserCode": "13579",  //处置人员编号
//            "dealUserName": null   //处置人姓名

    private String id;//主键
    private String dealType;//事件类型
    private String relateId;//关联ID
    private String dealStatus;//处置状态
    private String createTime;//创建事件
    private String dealDetail;//处置详情
    private String dealUserCode;//处置人员编号
    private String dealUserName;//处置人姓名
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getRelateId() {
        return relateId;
    }

    public void setRelateId(String relateId) {
        this.relateId = relateId;
    }

    public String getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(String dealStatus) {
        this.dealStatus = dealStatus;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getDealDetail() {
        return dealDetail;
    }

    public void setDealDetail(String dealDetail) {
        this.dealDetail = dealDetail;
    }

    public String getDealUserCode() {
        return dealUserCode;
    }

    public void setDealUserCode(String dealUserCode) {
        this.dealUserCode = dealUserCode;
    }

    public String getDealUserName() {
        return dealUserName;
    }

    public void setDealUserName(String dealUserName) {
        this.dealUserName = dealUserName;
    }
}
