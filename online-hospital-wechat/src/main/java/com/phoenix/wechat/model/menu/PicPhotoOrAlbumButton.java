package com.phoenix.wechat.model.menu;

/**
 * 拍照或者相册发图
 *
 * @since 0.0.1
 */
public class PicPhotoOrAlbumButton extends SingleButton {

    /**
     * 类型必须.菜单KEY值，用于消息接口推送，不超过128字节
     */
    private String key;

    public PicPhotoOrAlbumButton(String name, String key) {
        super(name);
        this.key = key;
    }

    public String getType() {
        return ButtonType.Pic_Photo_OR_Album.toString();
    }

    /**
     * 获取 菜单KEY值
     *
     * <p>
     * 类型必须.菜单KEY值，用于消息接口推送，不超过128字节</p>
     *
     * @return 菜单KEY值
     */
    public String getKey() {
        return key;
    }

    /**
     * 设置 菜单KEY值
     *
     * <p>
     * 类型必须.菜单KEY值，用于消息接口推送，不超过128字节</p>
     *
     * @param key 菜单KEY值
     */
    public void setKey(String key) {
        this.key = key;
    }
}
