package com.phoenix.wechat.model.menu;

/**
 * 永久素材(图片、音频、视频、图文消息)
 *
 * @since 0.0.1
 */
public class MediaIdButton extends SingleButton {

    /**
     * 类型必须.网页链接，用户点击菜单可打开链接，不超过256字节
     */
    private String mediaId;

    public MediaIdButton(String name, String mediaId) {
        super(name);
        this.mediaId = mediaId;
    }

    public String getType() {
        return ButtonType.Media_Id.toString();
    }

    /**
     * 获取 调用新增永久素材接口返回的合法media_id
     *
     * @return 调用新增永久素材接口返回的合法media_id
     */
    public String getMedia_Id() {
        return mediaId;
    }

    /**
     * 设置 调用新增永久素材接口返回的合法media_id
     *
     * @param mediaId 调用新增永久素材接口返回的合法media_id
     */
    public void setMedia_Id(String mediaId) {
        this.mediaId = mediaId;
    }
}
