package com.phoenix.wechat.spi;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.phoenix.wechat.model.message.OutputMessage;
import com.phoenix.wechat.model.message.normal.ImageInputMessage;
import com.phoenix.wechat.model.message.normal.LinkInputMessage;
import com.phoenix.wechat.model.message.normal.LocationInputMessage;
import com.phoenix.wechat.model.message.normal.NormalMessage;
import com.phoenix.wechat.model.message.normal.ShortVideoInputMessage;
import com.phoenix.wechat.model.message.normal.TextInputMessage;
import com.phoenix.wechat.model.message.normal.VideoInputMessage;
import com.phoenix.wechat.model.message.normal.VoiceInputMessage;
import com.phoenix.wechat.model.message.output.TextOutputMessage;

/**
 * <p>
 * Title: 微信公众平台接受消息处理器
 * </p>
 *
 * <p>
 * Description: 此消息处理器只负责接收消息和返回已收到消息的功能，无特殊功能。
 * </p>
 *
 * @since 0.0.6
 */
@Component
public class DefaultNormalMessageHandler implements INormalMessageHandler {
	
	private static Map<String, Object> msgMap;

	private OutputMessage allType(NormalMessage msg) {
		TextOutputMessage out = new TextOutputMessage();
		out.setContent("你的消息已经收到！");
		return out;
	}

	@Override
    public OutputMessage textTypeMsg(TextInputMessage msg) {
		String str = msgMap.get(msg.getContent()).toString();
		System.out.println("回复的消息：" + str);
        TextOutputMessage out = new TextOutputMessage();
		out.setContent(str);
		return out;
    }

	@Override
	public OutputMessage imageTypeMsg(ImageInputMessage msg) {
		return allType(msg);
	}

	@Override
	public OutputMessage voiceTypeMsg(VoiceInputMessage msg) {
		return allType(msg);
	}

	@Override
	public OutputMessage videoTypeMsg(VideoInputMessage msg) {
		return allType(msg);
	}

	@Override
	public OutputMessage shortvideoTypeMsg(ShortVideoInputMessage msg) {
		return allType(msg);
	}

	@Override
	public OutputMessage locationTypeMsg(LocationInputMessage msg) {
		return allType(msg);
	}

	@Override
	public OutputMessage linkTypeMsg(LinkInputMessage msg) {
		return allType(msg);
	}
}
