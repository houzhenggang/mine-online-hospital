package com.phoenix.wechat.model.message.normal;

import com.phoenix.wechat.model.message.MsgType;

/**
 * 链接消息
 *
 * @since 0.0.1
 */
public class LinkInputMessage extends NormalMessage {

    //消息标题
    private String Title;
    //消息描述
    private String Description;
    //消息链接
    private String Url;

    @Override
    public String getMsgType() {
        return MsgType.Link.toString();
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

}
