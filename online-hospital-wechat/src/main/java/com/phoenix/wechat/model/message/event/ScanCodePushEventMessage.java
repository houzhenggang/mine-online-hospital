package com.phoenix.wechat.model.message.event;

import com.phoenix.wechat.model.message.EventType;
import com.phoenix.wechat.model.message.ScanCodeInfo;

/**
 * 自定义菜单事件
 *
 * 扫码推事件的事件推送
 *
 * @since 0.0.1
 */
public class ScanCodePushEventMessage extends EventMessage {

    //事件KEY值，与自定义菜单接口中KEY值对应
    private String EventKey;
    //扫描信息
    private com.phoenix.wechat.model.message.ScanCodeInfo ScanCodeInfo;

    @Override
    public String getEvent() {
        return EventType.Scancode_Push.toString();
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String EventKey) {
        this.EventKey = EventKey;
    }

    public ScanCodeInfo getScanCodeInfo() {
        return ScanCodeInfo;
    }

    public void setScanCodeInfo(ScanCodeInfo ScanCodeInfo) {
        this.ScanCodeInfo = ScanCodeInfo;
    }

}
