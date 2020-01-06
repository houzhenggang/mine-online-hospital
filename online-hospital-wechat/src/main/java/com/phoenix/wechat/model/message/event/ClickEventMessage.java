package com.phoenix.wechat.model.message.event;

import com.phoenix.wechat.model.message.EventType;

/**
 * 自定义菜单事件
 * 
 * 点击菜单拉取消息时的事件推送
 *
 * @since 0.0.1
 */
public class ClickEventMessage extends EventMessage {

    //事件KEY值，与自定义菜单接口中KEY值对应
    private String EventKey;

    @Override
    public String getEvent() {
        return EventType.Click.toString();
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String EventKey) {
        this.EventKey = EventKey;
    }

}
