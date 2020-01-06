package com.phoenix.wechat.factory.defaults;

import org.springframework.stereotype.Component;

import com.phoenix.wechat.Weixin;
import com.phoenix.wechat.factory.WeixinFactory;

/**
 * DefaultWeixinFactory
 *
 * @since 1.0.0
 */
@Component
public class DefaultWeixinFactory implements WeixinFactory {

    private Weixin weixin;

    public void setWeixin(Weixin weixin) {
        this.weixin = weixin;
    }

    @Override
    public Weixin getWeixin() {
        return weixin;
    }
}
