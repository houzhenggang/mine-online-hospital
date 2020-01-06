package com.phoenix.wechat.component;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.phoenix.wechat.Configuration;
import com.phoenix.wechat.Weixin;
import com.phoenix.wechat.WeixinException;
import com.phoenix.wechat.http.HttpsClient;
import com.phoenix.wechat.http.Response;
import com.phoenix.wechat.model.redpack.SendRedPack;
import com.phoenix.wechat.model.redpack.SendRedPackResult;
import org.springframework.stereotype.Component;

/**
 * 红包组件
 *
 * @since 0.1.0
 */
@Component
public class RedpackComponent extends AbstractComponent {

    public RedpackComponent(Weixin weixin) {
        super(weixin);
    }

    /**
     * 发送现金红包
     *
     * <p>
     * 使用weixin4j.properties的配置</p>
     *
     * @param sendRedPack 现金红包对象
     * @return 发送现金红包返回结果对象
     * @throws WeixinException 微信操作异常
     */
    public SendRedPackResult sendRedPack(SendRedPack sendRedPack) throws WeixinException {
        String partnerId = this.weixin.getWeixinPayConfig().getPartnerId();
        String certPath = this.weixin.getWeixinPayConfig().getCertPath();
        String certSecret = this.weixin.getWeixinPayConfig().getCertSecret();
        return sendRedPack(sendRedPack, partnerId, certPath, certSecret);
    }

    /**
     * 发送现金红包
     *
     * @param sendRedPack 现金红包对象
     * @param partnerId 商户ID
     * @param certPath 证书路径
     * @param certSecret 证书密钥
     * @return 发送现金红包返回结果对象
     * @throws WeixinException 微信操作异常
     */
    public SendRedPackResult sendRedPack(SendRedPack sendRedPack, String partnerId, String certPath, String certSecret) throws WeixinException {
        //将统一下单对象转成XML
        String xmlPost = sendRedPack.toXML();
        if (Configuration.isDebug()) {
            System.out.println("调试模式_发送现金红包接口 提交XML数据：" + xmlPost);
        }
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //提交xml格式数据
        Response res = http.postXml("https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack", xmlPost, partnerId, certPath, certSecret);
        //获取微信平台下单接口返回数据
        String xmlResult = res.asString();
        try {
            JAXBContext context = JAXBContext.newInstance(SendRedPackResult.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            SendRedPackResult result = (SendRedPackResult) unmarshaller.unmarshal(new StringReader(xmlResult));
            return result;
        } catch (JAXBException ex) {
            return null;
        }
    }
}
