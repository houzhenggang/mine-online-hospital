package com.phoenix.wechat.model.menu;

/**
 * 打开小程序
 *
 * @since 0.1.2
 */
public class MiniprogramButton extends SingleButton {

    /**
     * 小程序的appid（仅认证公众号可配置）
     */
    private String appid;
    /**
     * 小程序的页面路径
     */
    private String pagepath;
    /**
     * 网页 链接，用户点击菜单可打开链接，不超过1024字节。
     *
     * 不支持小程序的老版本客户端将打开本url。
     */
    private String url;

    public MiniprogramButton(String name) {
        super(name);
    }

    public MiniprogramButton(String name, String appid, String pagepath, String url) {
        super(name);
        this.appid = appid;
        this.pagepath = pagepath;
        this.url = url;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
