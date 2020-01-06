package com.phoenix.wechat.model.message.event;

import com.phoenix.wechat.model.message.EventType;

/**
 * 扫描带参数二维码事件
 * 
 * 用户已关注
 *
 * @since 0.0.1
 */
public class QrsceneScanEventMessage extends EventMessage {

    //事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
    private String EventKey;
    //二维码的ticket，可用来换取二维码图片
    private String Ticket;

    @Override
    public String getEvent() {
        return EventType.Scan.toString();
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String EventKey) {
        this.EventKey = EventKey;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String Ticket) {
        this.Ticket = Ticket;
    }

}
