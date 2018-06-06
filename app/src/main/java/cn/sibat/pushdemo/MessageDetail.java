package cn.sibat.pushdemo;

public class MessageDetail {
    private String detail_time;
    private String detail_message;
    private String detail_user;
    private String detail_iv;
    private int index;

    public MessageDetail() {
    }

    public MessageDetail(String detail_time, String detail_message, String detail_user, String detail_iv, int index) {
        this.detail_time = detail_time;
        this.detail_message = detail_message;
        this.detail_user = detail_user;
        this.detail_iv = detail_iv;
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDetail_time() {
        return detail_time;
    }

    public void setDetail_time(String detail_time) {
        this.detail_time = detail_time;
    }

    public String getDetail_message() {
        return detail_message;
    }

    public void setDetail_message(String detail_message) {
        this.detail_message = detail_message;
    }

    public String getDetail_user() {
        return detail_user;
    }

    public void setDetail_user(String detail_user) {
        this.detail_user = detail_user;
    }

    public String getDetail_iv() {
        return detail_iv;
    }

    public void setDetail_iv(String detail_iv) {
        this.detail_iv = detail_iv;
    }
}
