package com.phoenix.wechat.model.message.output;

import com.phoenix.wechat.model.message.OutputMessage;

/**
 * 这个类实现了<tt>OutputMessage</tt>，用来回复文本消息
 *
 * <p>
 * 提供了获取文本内容<code>getContent()</code>等主要方法.</p>
 *
 * @since 0.0.1
 */
public class TextOutputMessage extends OutputMessage {

    /**
     * 消息类型:文本消息
     */
    private final String MsgType = "text";
    /**
     * 文本消息
     */
    private String Content;

    /**
     * 创建一个新的 Output Message.并且MsgType的值为text.
     */
    public TextOutputMessage() {
    }

    /**
     * 创建一个自定义文本内容content的Output Message.
     *
     * @param content 文本内容
     */
    public TextOutputMessage(String content) {
        Content = content;
    }

    /**
     * 获取 消息类型
     *
     * @return 消息类型
     */
    @Override
    public String getMsgType() {
        return MsgType;
    }

    /**
     * 获取 文本消息
     *
     * @return 文本消息
     */
    public String getContent() {
        return Content;
    }

    /**
     * 设置 文本消息
     *
     * @param content 文本消息
     */
    public void setContent(String content) {
        Content = content;
    }

    @Override
    public String toXML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<xml>");
        sb.append("<ToUserName><![CDATA[").append(this.getToUserName()).append("]]></ToUserName>");
        sb.append("<FromUserName><![CDATA[").append(this.getFromUserName()).append("]]></FromUserName>");
        sb.append("<CreateTime>").append(this.getCreateTime()).append("</CreateTime>");
        sb.append("<MsgType><![CDATA[" + this.MsgType + "]]></MsgType>");
        sb.append("<Content><![CDATA[").append(this.getContent()).append("]]></Content>");
        sb.append("</xml>");
        return sb.toString();
    }
}
