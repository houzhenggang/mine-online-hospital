package com.phoenix.wechat.model.message.normal;

import com.phoenix.wechat.model.message.MsgType;

/**
 * 文本消息
 *
 * @since 0.0.1
 */
public class TextInputMessage extends NormalMessage {

    //文本消息内容
    private String Content;

    public TextInputMessage(String Content) {
        this.Content = Content;
    }

    @Override
    public String getMsgType() {
        return MsgType.Text.toString();
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }
}
