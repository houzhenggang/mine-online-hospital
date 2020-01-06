package com.phoenix.wechat.component;

import com.alibaba.fastjson.JSONObject;
import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

import com.phoenix.wechat.Configuration;
import com.phoenix.wechat.Weixin;
import com.phoenix.wechat.WeixinException;
import com.phoenix.wechat.http.HttpClient;
import org.springframework.stereotype.Component;

import com.phoenix.wechat.model.media.Attachment;

/**
 * 文件组件，已过时，推荐使用Media组件
 * 
 * @since 0.1.0
 */
@Component
@Deprecated
public class FileComponent extends AbstractComponent {

    public FileComponent(Weixin weixin) {
        super(weixin);
    }

    /**
     * 上传媒体文件
     *
     * @param mediaType 媒体文件类型，分别有图片（image）、语音（voice）、视频（video）和缩略图（thumb）
     * @param file form-data中媒体文件标识，有filename、filelength、content-type等信息
     * @return 上传成功返回素材Id，否则返回null
     * @throws WeixinException 微信操作异常
     */
    @Deprecated
    public String upload(String mediaType, File file) throws WeixinException {
        try {
            //创建请求对象
            HttpClient http = new HttpClient();
            //上传素材，返回JSON数据包
            String jsonStr = http.upload("http://file.api.weixin.qq.com/cgi-bin/media/upload?access_token=" + weixin.getToken().getAccess_token() + "&type=" + mediaType, file);
            JSONObject jsonObj = JSONObject.parseObject(jsonStr);
            if (jsonObj != null) {
                if (Configuration.isDebug()) {
                    System.out.println("上传多媒体文件返回json：" + jsonObj.toString());
                }
                Object errcode = jsonObj.get("errcode");
                if (errcode != null && !errcode.toString().equals("0")) {
                    //返回异常信息
                    throw new WeixinException(getCause(jsonObj.getIntValue("errcode")));
                } else {
                    //返回多媒体文件id
                    return jsonObj.getString("media_id");
                }
            }
            return null;
        } catch (IOException ex) {
            throw new WeixinException("上传多媒体文件异常:", ex);
        } catch (NoSuchAlgorithmException ex) {
            throw new WeixinException("上传多媒体文件异常:", ex);
        } catch (NoSuchProviderException ex) {
            throw new WeixinException("上传多媒体文件异常:", ex);
        } catch (KeyManagementException ex) {
            throw new WeixinException("上传多媒体文件异常:", ex);
        } catch (NumberFormatException ex) {
            throw new WeixinException("上传多媒体文件异常:", ex);
        } catch (WeixinException ex) {
            throw new WeixinException("上传多媒体文件异常:", ex);
        }
    }

    /**
     * 下载多媒体文件
     *
     * @param mediaId 媒体文件ID
     * @return 正确返回附件对象，否则返回null
     * @throws WeixinException 微信操作异常
     */
    @Deprecated
    public Attachment download(String mediaId) throws WeixinException {
        try {
            //下载资源
            String url = "http://file.api.weixin.qq.com/cgi-bin/media/get?access_token=" + weixin.getToken().getAccess_token() + "&media_id=" + mediaId;
            //创建请求对象
            HttpClient http = new HttpClient();
            return http.download(url);
        } catch (IOException ex) {
            throw new WeixinException("下载多媒体文件异常:", ex);
        }
    }
}
