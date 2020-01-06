package com.phoenix.wechat.model.message.template;

import java.util.List;

/**
 * 实体类对象，发送模板消息对象
 *
 * @since 0.1.0
 */
public class TemplateMessage implements java.io.Serializable {

    /**
     * 接收者openid，对应官方参数touser
     */
    private String openid;
    /**
     * 模板ID
     */
    private String templateId;
    /**
     * 模板跳转链接
     */
    private String url;
    /**
     * 跳小程序所需数据，不需跳小程序可不用传该数据
     */
    private Miniprogram miniprogram;
    /**
     * 模板数据
     */
    private List<TemplateData> data;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Miniprogram getMiniprogram() {
        return miniprogram;
    }

    public void setMiniprogram(Miniprogram miniprogram) {
        this.miniprogram = miniprogram;
    }

    public List<TemplateData> getData() {
        return data;
    }

    public void setData(List<TemplateData> data) {
        this.data = data;
    }

}
