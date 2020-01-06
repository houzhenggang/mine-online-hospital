package com.phoenix.wechat.model.message.event;

import com.phoenix.wechat.model.message.EventType;
import com.phoenix.wechat.model.message.SendPicsInfo;

/**
 * 自定义菜单事件
 *
 * 弹出拍照或者相册发图的事件推送
 *
 * @since 0.0.1
 */
public class PicPhotoOrAlbumEventMessage extends EventMessage {

    //事件KEY值，与自定义菜单接口中KEY值对应
    private String EventKey;
    //发送的图片信息
    private com.phoenix.wechat.model.message.SendPicsInfo SendPicsInfo;

    @Override
    public String getEvent() {
        return EventType.Pic_Photo_OR_Album.toString();
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String EventKey) {
        this.EventKey = EventKey;
    }

    public SendPicsInfo getSendPicsInfo() {
        return SendPicsInfo;
    }

    public void setSendPicsInfo(SendPicsInfo SendPicsInfo) {
        this.SendPicsInfo = SendPicsInfo;
    }

}
