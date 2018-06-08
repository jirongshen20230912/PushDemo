package cn.sibat.pushdemo.bean;

import java.util.List;

public class UrlDataList {
    private String status;
    private String msg;
    private String time;
    private List<StyleData> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<StyleData> getData() {
        return data;
    }

    public void setData(List<StyleData> data) {
        this.data = data;
    }
}
