package com.phoenix.wechat.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.phoenix.wechat.utils.WXAuthUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSONObject;


@Controller
@RequestMapping("/wx")
public class WXLoginController {

    private static final Logger logger = Logger.getLogger(WXLoginController.class);

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpServletResponse response;

    /**
     * 公众号微信登录授权
     *
     * @param request
     * @param response
     * @return
     * @throws ParseException
     * @parameter
     */
    @RequestMapping(value = "/wxLogin", method = RequestMethod.GET)
    public String wxLogin() throws ParseException, UnsupportedEncodingException {
        System.out.println("wxLogin");
        // 这个url的域名必须要进行再公众号中进行注册验证，这个地址是成功后的回调地址
        String backUrl = "http://28o51m5650.qicp.vip/wx/callBack";
        // 第一步：用户同意授权，获取code
        String getCodeUrl = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + WXAuthUtil.APPID + "&redirect_uri="
                + URLEncoder.encode(backUrl,"utf-8") + "&response_type=code" + "&scope=snsapi_userinfo"
                + "&state=STATE#wechat_redirect";
        logger.info("获取code, getCodeUrl=" + getCodeUrl);
        // response.sendRedirect(url);
        return "redirect:" + getCodeUrl;// 必须重定向，否则不能成功
    }

    /**
     * 公众号微信登录授权回调函数
     *
     * @param modelMap
     * @param req
     * @param resp
     * @return
     * @throws ServletException
     * @throws IOException
     * @parameter
     */
    @RequestMapping(value = "/callBack", method = RequestMethod.GET)
    @ResponseBody
    public String callBack() throws ServletException, IOException {
        String code = request.getParameter("code");
        // 第二步：通过code换取网页授权access_token
        String getTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + WXAuthUtil.APPID + "&secret="
                + WXAuthUtil.APPSECRET + "&code=" + code + "&grant_type=authorization_code";
        logger.info("获取token,getTokenUrl=" + getTokenUrl);
        JSONObject getTokenJson = WXAuthUtil.doGetJson(getTokenUrl);

        /*
         * { "access_token":"ACCESS_TOKEN", "expires_in":7200,
         * "refresh_token":"REFRESH_TOKEN", "openid":"OPENID", "scope":"SCOPE" }
         */
        logger.info("获取token,getTokenJson=" + getTokenJson.toJSONString());

        String openid = getTokenJson.getString("openid");
        String access_token = getTokenJson.getString("access_token");
        String refresh_token = getTokenJson.getString("refresh_token");

        // 第五步验证access_token是否失效；展示都不需要
        String vlidTokenUrl = "https://api.weixin.qq.com/sns/auth?access_token=" + access_token + "&openid=" + openid;
        logger.info("验证token,vlidTokenUrl=" + vlidTokenUrl);
        JSONObject validTokenJson = WXAuthUtil.doGetJson(vlidTokenUrl);
        logger.info("验证token,validTokenJson=" + validTokenJson.toJSONString());
        if (!"0".equals(validTokenJson.getString("errcode"))) {
            // 第三步：刷新access_token（如果需要）-----暂时没有使用,参考文档https://mp.weixin.qq.com/wiki，
            String refreshTokenUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=" + openid
                    + "&grant_type=refresh_token&refresh_token=" + refresh_token;
            logger.info("刷新token,refreshTokenUrl=" + refreshTokenUrl);
            JSONObject refreshTokenJson = WXAuthUtil.doGetJson(refreshTokenUrl);
            /*
             * { "access_token":"ACCESS_TOKEN", "expires_in":7200,
             * "refresh_token":"REFRESH_TOKEN", "openid":"OPENID", "scope":"SCOPE" }
             */
            logger.info("刷新token,refreshTokenJson=" + refreshTokenJson.toJSONString());
            access_token = refreshTokenJson.getString("access_token");
        }


        // 第四步：拉取用户信息(需scope为 snsapi_userinfo)
        String getUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo?access_token=" + access_token + "&openid=" + openid
                + "&lang=zh_CN";
        logger.info("获取用户信息，getUserInfoUrl=" + getUserInfoUrl.toString());
        JSONObject getUserInfoJson = WXAuthUtil.doGetJson(getUserInfoUrl);
        /*
         * { "openid":" OPENID", " nickname": NICKNAME, "sex":"1", "province":"PROVINCE"
         * "city":"CITY", "country":"COUNTRY", "headimgurl":
         * "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/46",
         * "privilege":[ "PRIVILEGE1" "PRIVILEGE2" ], "unionid":
         * "o6_bmasdasdsad6_2sgVt7hMZOPfL" }
         */
        logger.info("获取用户信息，getUserInfoJson=" + getUserInfoJson.toString());
        /*
         * end 获取微信用户基本信息
         */
        // 获取到用户信息后就可以进行重定向，走自己的业务逻辑了。。。。。。
        // 接来的逻辑就是你系统逻辑了，请自由发挥
        return getUserInfoJson.toString();
    }

}