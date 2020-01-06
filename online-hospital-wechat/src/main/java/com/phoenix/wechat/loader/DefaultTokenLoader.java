package com.phoenix.wechat.loader;

import org.apache.commons.lang3.StringUtils;

import com.phoenix.wechat.model.base.Token;

/**
 * 内存式AccessToken存储器
 *
 * 单项目时使用（生产环境不推荐）
 *
 * @since 0.1.0
 */
public class DefaultTokenLoader implements ITokenLoader {

    /**
     * AccessToken对象
     */
    private Token token = null;

    @Override
    public Token get() {
        return (token == null
                || StringUtils.isEmpty(token.getAccess_token())
                || token.isExprexpired()) ? null : token;
    }

    @Override
    public void refresh(Token token) {
        if (null == token || StringUtils.isEmpty(token.getAccess_token())) {
            throw new IllegalStateException("access_token is null or empty");
        }
        if (token.getCreate_time() <= 0) {
            throw new IllegalStateException("createtime can not be zero");
        }
        if (token.isExprexpired()) {
            throw new IllegalStateException("access_token is exprexpired");
        }
        this.token = token;
    }

}
