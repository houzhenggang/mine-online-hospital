package com.phoenix.wechat.model.material;

import java.util.Date;
import com.phoenix.wechat.model.message.MediaType;

/**
 * 上传成功后的素材对象
 *
 * @since 0.1.4
 */
public class Media {

    /**
     * 媒体文件类型
     *
     * 分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb，主要用于视频与音乐格式的缩略图）
     */
    private MediaType mediaType;
    /**
     * 媒体文件上传后，获取标识
     */
    private String mediaId;
    /**
     * 媒体文件上传时间
     */
    private Date createdAt;

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

}
