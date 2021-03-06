package com.phoenix.wechat.model.sns;

import com.alibaba.fastjson.JSONObject;
import com.phoenix.wechat.WeixinException;
import java.util.Date;
import com.phoenix.wechat.http.Response;

/**
 * 网页授权对象
 *
 * @since 0.1.0
 */
public final class SnsAccessToken {

    private String access_token;
    private int expires_in = 7200;
    private String refresh_token;
    private long exprexpired_time;
    private String openid;
    private String scope;

    /**
     * 通过输出对象，从输出对象转换为JSON对象，后获取JSON数据包
     *
     * <p>
     * 正常情况下，微信会返回下述JSON数据包给公众号：
     * {"scope":"snsapi_base","openid":"oK4ipw98o-ngjWfSE5WTZmu1hFT0","expires_in":7200,"refresh_token":"5_1wek3jV4FWN9G2HRPb-jjOfy5RQB-neSOAk1l25BogAxfm7G6ELOmxw2xARSYtbg4F3u2hHylqA9O-Um_cv46Q","access_token":"5_g9mZD7zzUGzqtqQjXDBP4BXL1mzvCfl7PvJNc-OGKBq8xwNV_iMEm47fQaj1KhoUrEAhu5VkSXLlICEzt9Zg-A"}</p>
     *
     * @param response 输出对象
     * @throws WeixinException 微信操作异常
     */
    public SnsAccessToken(Response response) throws WeixinException {
        this(response.asJSONObject());
    }

    /**
     * 通过微信公众平台返回JSON对象创建凭证对象
     *
     * <p>
     * 正常情况下，微信会返回下述JSON数据包给公众号：
     * {"scope":"snsapi_base","openid":"oK4ipw98o-ngjWfSE5WTZmu1hFT0","expires_in":7200,"refresh_token":"5_1wek3jV4FWN9G2HRPb-jjOfy5RQB-neSOAk1l25BogAxfm7G6ELOmxw2xARSYtbg4F3u2hHylqA9O-Um_cv46Q","access_token":"5_g9mZD7zzUGzqtqQjXDBP4BXL1mzvCfl7PvJNc-OGKBq8xwNV_iMEm47fQaj1KhoUrEAhu5VkSXLlICEzt9Zg-A"}</p>
     *
     * @param jsonObj JSON数据包
     * @throws WeixinException 微信操作异常
     */
    public SnsAccessToken(JSONObject jsonObj) throws WeixinException {
        this.access_token = jsonObj.getString("access_token");
        this.expires_in = jsonObj.getIntValue("expires_in");
        this.refresh_token = jsonObj.getString("refresh_token");
        this.openid = jsonObj.getString("openid");
        this.scope = jsonObj.getString("scope");
        //设置下次过期时间 = 当前时间 + (凭证有效时间(秒) * 1000)
        this.exprexpired_time = new Date().getTime() + (this.expires_in * 1000);
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    /**
     * 判断用户凭证是否过期
     *
     * @return 过期返回 true,否则返回false
     */
    public boolean isExprexpired() {
        Date now = new Date();
        long nowLong = now.getTime();
        return nowLong > exprexpired_time;
    }

    /**
     * 将数据转换为JSON数据包
     *
     * @return JSON数据包
     */
    @Override
    public String toString() {
        return "{\"scope\":\"" + this.getScope()
                + "\",\"openid\":\"" + this.getOpenid()
                + "\",\"expires_in\":" + this.getExpires_in()
                + ",\"refresh_token\":\"" + this.getRefresh_token()
                + "\",\"access_token\":\"" + this.getAccess_token() + "\"}";
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
