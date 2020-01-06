package com.phoenix.wechat.model.message;

/**
 * 消息类型
 *
 * @since 0.0.1
 */
public enum MsgType {

    /**
     * 1 文本消息
     */
    Text("text"),
    /**
     * 2 图片消息
     */
    Image("image"),
    /**
     * 3 语音消息
     */
    Voice("voice"),
    /**
     * 4 视频消息
     */
    Video("video"),
    /**
     * 5 小视频消息
     */
    ShortVideo("shortvideo"),
    /**
     * 6 地理位置消息
     */
    Location("location"),
    /**
     * 7 链接消息
     */
    Link("link"),
    /**
     * 事件消息
     */
    Event("event"),
    /**
     * 音乐消息
     */
    Music("music"),
    /**
     * 图文消息
     */
    News("news");
    private String value = "";

    MsgType(String value) {
        this.value = value;
    }

    /**
     * @return the msgType
     */
    @Override
    public String toString() {
        return value;
    }
}
