package com.phoenix.wechat.component;

import com.phoenix.wechat.Weixin;
import com.phoenix.wechat.WeixinBuilder;
import com.phoenix.wechat.WeixinSupport;

/**
 * 微信组件基础类
 * 
 * @since 0.1.0
 */
public abstract class AbstractComponent extends WeixinSupport {
	
	/**
     * 构造器
     */
    public AbstractComponent(){
    	this.weixin = WeixinBuilder.newInstance().build();
    }

    protected Weixin weixin;

    public AbstractComponent(Weixin weixin) {
        if (weixin == null) {
            throw new IllegalArgumentException("weixin can not be null");
        }
        this.weixin = weixin;
    }
}
