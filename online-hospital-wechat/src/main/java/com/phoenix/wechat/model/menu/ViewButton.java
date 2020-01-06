package com.phoenix.wechat.model.menu;

/**
 * 跳转URL
 *
 * @since 0.0.1
 */
public class ViewButton extends SingleButton {

    /**
     * view类型必须.网页链接，用户点击菜单可打开链接，不超过256字节
     */
    private String url;

    public ViewButton(String name) {
        super(name);
    }

    public ViewButton(String name, String url) {
        super(name);
        this.url = url;
    }

    public String getType() {
        return ButtonType.View.toString();
    }

    /**
     * 获取 网页链接
     *
     * <p>
     * view类型必须.网页链接，用户点击菜单可打开链接，不超过256字节
     * </p>
     *
     * @return 网页链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置 网页链接
     *
     * <p>
     * view类型必须.网页链接，用户点击菜单可打开链接，不超过256字节
     * </p>
     *
     * @param url 网页链接
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
