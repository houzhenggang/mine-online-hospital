package com.phoenix.wechat;

/**
 * 微信支付配置
 *
 * @since 0.1.3
 */
public class WeixinPayConfig {

    /**
     * 微信支付_商户ID
     */
    private String partnerId;
    /**
     * 微信支付_商户密钥
     */
    private String partnerKey;
    /**
     * 微信支付_通知URL
     */
    private String notifyUrl;
    /**
     * 证书路径
     */
    private String certPath;
    /**
     * 证书密钥
     */
    private String certSecret;

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerKey() {
        return partnerKey;
    }

    public void setPartnerKey(String partnerKey) {
        this.partnerKey = partnerKey;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getCertPath() {
        return certPath;
    }

    public void setCertPath(String certPath) {
        this.certPath = certPath;
    }

    public String getCertSecret() {
        return certSecret;
    }

    public void setCertSecret(String certSecret) {
        this.certSecret = certSecret;
    }
}
