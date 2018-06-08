package cn.sibat.pushdemo.bean;

import java.util.List;

public class DetailData {
    private StyleData data;
    private List<StatusListData> logList;

    public StyleData getData() {
        return data;
    }

    public void setData(StyleData data) {
        this.data = data;
    }

    public List<StatusListData> getLogList() {
        return logList;
    }

    public void setLogList(List<StatusListData> logList) {
        this.logList = logList;
    }
}
