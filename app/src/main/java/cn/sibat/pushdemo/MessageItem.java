package cn.sibat.pushdemo;

public class MessageItem {
    private String messageInfo;
    private String messageTime;

    public MessageItem() {
    }

    public MessageItem(String messageInfo, String messageTime) {
        this.messageInfo = messageInfo;
        this.messageTime = messageTime;
    }

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }
}
