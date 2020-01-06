package com.phoenix.wechat.model.message.event;

import com.phoenix.wechat.model.message.EventType;

/**
 * 自定义菜单事件
 *
 * 点击菜单跳转链接时的事件推送
 *
 * @since 0.0.1
 */
public class ViewEventMessage extends EventMessage {

    //事件KEY值，设置的跳转URL
    private String EventKey;
    private String MenuId;

    @Override
    public String getEvent() {
        return EventType.View.toString();
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String EventKey) {
        this.EventKey = EventKey;
    }

    public String getMenuId() {
        return MenuId;
    }

    public void setMenuId(String MenuId) {
        this.MenuId = MenuId;
    }

}
