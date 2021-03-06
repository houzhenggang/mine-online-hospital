package com.phoenix.wechat.model.user;

import java.util.List;

/**
 * 微信平台关注者openid数据对象
 *
 * @since 0.0.1
 */
public class Data {

    private List<String> openid;  //列表数据，OPENID的列表

    public List<String> getOpenid() {
        return openid;
    }

    public void setOpenid(List<String> openid) {
        this.openid = openid;
    }
}
