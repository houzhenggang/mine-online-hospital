package com.phoenix.wechat.model.message.normal;

import com.phoenix.wechat.model.message.MsgType;

/**
 * 图片消息
 *
 * @since 0.0.1
 */
public class ImageInputMessage extends NormalMessage {

    //图片链接
    private String PicUrl;
    //图片消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String MediaId;

    @Override
    public String getMsgType() {
        return MsgType.Image.toString();
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String PicUrl) {
        this.PicUrl = PicUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String MediaId) {
        this.MediaId = MediaId;
    }

}
