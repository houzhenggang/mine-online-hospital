package com.phoenix.wechat.spi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.phoenix.wechat.Weixin;
import com.phoenix.wechat.model.message.OutputMessage;
import com.phoenix.wechat.model.message.event.ClickEventMessage;
import com.phoenix.wechat.model.message.event.EventMessage;
import com.phoenix.wechat.model.message.event.LocationEventMessage;
import com.phoenix.wechat.model.message.event.LocationSelectEventMessage;
import com.phoenix.wechat.model.message.event.PicPhotoOrAlbumEventMessage;
import com.phoenix.wechat.model.message.event.PicSysPhotoEventMessage;
import com.phoenix.wechat.model.message.event.PicWeixinEventMessage;
import com.phoenix.wechat.model.message.event.QrsceneScanEventMessage;
import com.phoenix.wechat.model.message.event.QrsceneSubscribeEventMessage;
import com.phoenix.wechat.model.message.event.ScanCodePushEventMessage;
import com.phoenix.wechat.model.message.event.ScanCodeWaitMsgEventMessage;
import com.phoenix.wechat.model.message.event.SubscribeEventMessage;
import com.phoenix.wechat.model.message.event.UnSubscribeEventMessage;
import com.phoenix.wechat.model.message.event.ViewEventMessage;
import com.phoenix.wechat.model.message.output.TextOutputMessage;

/**
 * 默认事件消息处理器
 *
 * @since 0.0.6
 */
@Component
public class DefaultEventMessageHandler implements IEventMessageHandler {

	@Autowired
    private Weixin weixin;
	
    private OutputMessage allType(EventMessage msg) {
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("你的消息已经收到！");
        return out;
    }

    @Override
    public OutputMessage subscribe(SubscribeEventMessage msg) {
    	System.out.println("关注事件");
        TextOutputMessage out = new TextOutputMessage();
        out.setContent("欢迎关注南京市智慧医疗");
        return out;
    }

    @Override
    public OutputMessage unSubscribe(UnSubscribeEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage qrsceneSubscribe(QrsceneSubscribeEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage qrsceneScan(QrsceneScanEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage location(LocationEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage click(ClickEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage view(ViewEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage scanCodePush(ScanCodePushEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage scanCodeWaitMsg(ScanCodeWaitMsgEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage picSysPhoto(PicSysPhotoEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage picPhotoOrAlbum(PicPhotoOrAlbumEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage picWeixin(PicWeixinEventMessage msg) {
        return allType(msg);
    }

    @Override
    public OutputMessage locationSelect(LocationSelectEventMessage msg) {
        return allType(msg);
    }

}
