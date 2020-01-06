package com.phoenix.wechat.component;

import com.phoenix.wechat.Configuration;
import com.phoenix.wechat.Weixin;
import com.phoenix.wechat.WeixinException;
import com.phoenix.wechat.http.HttpsClient;
import com.phoenix.wechat.http.Response;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.phoenix.wechat.model.menu.Menu;

/**
 * 自定义菜单组件
 *
 * @since 0.1.0
 */
@Component
public class MenuComponent extends AbstractComponent {

    public MenuComponent(Weixin weixin) {
        super(weixin);
    }

    /**
     * 创建自定义菜单
     *
     * @param menu 菜单对象
     * @throws WeixinException 微信操作异常 创建自定义菜单异常
     */
    public void create(Menu menu) throws WeixinException {
        //内部业务验证
        if (menu == null || menu.getButton() == null) {
            throw new IllegalArgumentException("menu can't be null or menu.button can't be null");
        }
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + weixin.getToken().getAccess_token(), menu.toJSONObject());
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("/menu/create返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
            }
        }
    }

    /**
     * 查询自定义菜单
     *
     * @return 自定义菜单对象
     * @throws WeixinException 微信操作异常 查询自定义菜单对象异常
     */
    public Menu get() throws WeixinException {
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = http.post("https://api.weixin.qq.com/cgi-bin/menu/get?access_token=" + weixin.getToken().getAccess_token(), null);
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("/menu/get返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
            }
            //返回自定义菜单对象
            return new Menu(jsonObj);
        }
        //返回自定义菜单对
        return null;
    }

    /**
     * 删除自定义菜单
     *
     * @throws WeixinException 微信操作异常 删除自定义菜单异常
     */
    public void delete() throws WeixinException {
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //调用获取access_token接口
        Response res = http.get("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=" + weixin.getToken().getAccess_token());
        //根据请求结果判定，是否验证成功
        JSONObject jsonObj = res.asJSONObject();
        if (jsonObj != null) {
            if (Configuration.isDebug()) {
                System.out.println("/menu/delete返回json：" + jsonObj.toString());
            }
            Object errcode = jsonObj.get("errcode");
            if (errcode != null && !errcode.toString().equals("0")) {
                //返回异常信息
                throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
            }
        }
    }
}
