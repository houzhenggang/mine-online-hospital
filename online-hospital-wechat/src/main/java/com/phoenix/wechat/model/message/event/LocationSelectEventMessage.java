package com.phoenix.wechat.model.message.event;

import com.phoenix.wechat.model.message.EventType;
import com.phoenix.wechat.model.message.SendLocationInfo;

/**
 * 自定义菜单事件
 *
 * 弹出地理位置选择器的事件推送
 *
 * @since 0.0.1
 */
public class LocationSelectEventMessage extends EventMessage {

    //事件KEY值，与自定义菜单接口中KEY值对应
    private String EventKey;
    //发送的位置信息
    private com.phoenix.wechat.model.message.SendLocationInfo SendLocationInfo;

    @Override
    public String getEvent() {
        return EventType.Location_Select.toString();
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String EventKey) {
        this.EventKey = EventKey;
    }

    public SendLocationInfo getSendLocationInfo() {
        return SendLocationInfo;
    }

    public void setSendLocationInfo(SendLocationInfo SendLocationInfo) {
        this.SendLocationInfo = SendLocationInfo;
    }

}
