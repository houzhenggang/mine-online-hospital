package com.phoenix.wechat.model.message.normal;

import com.phoenix.wechat.model.message.MsgType;

/**
 * 小视频消息
 *
 * @since 0.0.7
 */
public class ShortVideoInputMessage extends NormalMessage {

    //视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
    private String MediaId;
    //视频消息 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。
    private String ThumbMediaId;

    @Override
    public String getMsgType() {
        return MsgType.ShortVideo.toString();
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String MediaId) {
        this.MediaId = MediaId;
    }

    public String getThumbMediaId() {
        return ThumbMediaId;
    }

    public void setThumbMediaId(String ThumbMediaId) {
        this.ThumbMediaId = ThumbMediaId;
    }
}
