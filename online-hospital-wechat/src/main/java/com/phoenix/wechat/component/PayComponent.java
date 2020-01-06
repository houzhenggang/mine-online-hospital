package com.phoenix.wechat.component;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.phoenix.wechat.Configuration;
import com.phoenix.wechat.WeixinException;
import com.phoenix.wechat.http.HttpsClient;
import com.phoenix.wechat.http.Response;
import org.springframework.stereotype.Component;

import com.phoenix.wechat.Weixin;
import com.phoenix.wechat.model.pay.OrderQuery;
import com.phoenix.wechat.model.pay.OrderQueryResult;
import com.phoenix.wechat.model.pay.UnifiedOrder;
import com.phoenix.wechat.model.pay.UnifiedOrderResult;

/**
 * 支付组件
 *
 * @since 0.1.0
 */
@Component
public class PayComponent extends AbstractComponent {

    public PayComponent(Weixin weixin) {
        super(weixin);
    }

    /**
     * 统一下单
     *
     * @param unifiedorder 统一下单对象
     * @return 下单返回结果对象
     * @throws WeixinException 微信操作异常
     */
    public UnifiedOrderResult payUnifiedOrder(UnifiedOrder unifiedorder) throws WeixinException {
        //将统一下单对象转成XML
        String xmlPost = unifiedorder.toXML();
        if (Configuration.isDebug()) {
            System.out.println("调试模式_统一下单接口 提交XML数据：" + xmlPost);
        }
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //提交xml格式数据
        Response res = http.postXml("https://api.mch.weixin.qq.com/pay/unifiedorder", xmlPost);
        //获取微信平台下单接口返回数据
        String xmlResult = res.asString();
        try {
            JAXBContext context = JAXBContext.newInstance(UnifiedOrderResult.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            UnifiedOrderResult result = (UnifiedOrderResult) unmarshaller.unmarshal(new StringReader(xmlResult));
            return result;
        } catch (JAXBException ex) {
            return null;
        }
    }

    /**
     * 查询订单
     *
     * @param orderQuery 订单查询对象
     * @return 订单查询结果
     * @throws WeixinException 微信操作异常
     */
    public OrderQueryResult payOrderQuery(OrderQuery orderQuery) throws WeixinException {
        //将统一下单对象转成XML
        String xmlPost = orderQuery.toXML();
        if (Configuration.isDebug()) {
            System.out.println("调试模式_查询订单接口 提交XML数据：" + xmlPost);
        }
        //创建请求对象
        HttpsClient http = new HttpsClient();
        //提交xml格式数据
        Response res = http.postXml("https://api.mch.weixin.qq.com/pay/orderquery", xmlPost);
        //获取微信平台查询订单接口返回数据
        String xmlResult = res.asString();
        try {
            if (Configuration.isDebug()) {
                System.out.println("调试模式_查询订单接口 接收XML数据：" + xmlResult);
            }
            JAXBContext context = JAXBContext.newInstance(OrderQueryResult.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            OrderQueryResult result = (OrderQueryResult) unmarshaller.unmarshal(new StringReader(xmlResult));
            return result;
        } catch (JAXBException ex) {
            return null;
        }
    }
}
