package com.phoenix.wechat.loader;

import com.phoenix.wechat.model.base.Token;

/**
 * AccessToken加载接口
 *
 * @since 0.1.0
 */
public interface ITokenLoader {

    /**
     * 获取access_token
     *
     * @return 包含access_token数据的对象
     */
    public Token get();

    /**
     * 刷新access_token
     *
     * @param accessToken 包含access_token数据的对象
     */
    public void refresh(Token accessToken);
}
