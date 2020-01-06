package com.phoenix.wechat.spi;

import com.phoenix.wechat.model.message.normal.TextInputMessage;
import com.phoenix.wechat.model.message.normal.ImageInputMessage;
import com.phoenix.wechat.model.message.normal.LinkInputMessage;
import com.phoenix.wechat.model.message.normal.LocationInputMessage;
import com.phoenix.wechat.model.message.normal.ShortVideoInputMessage;
import com.phoenix.wechat.model.message.normal.VideoInputMessage;
import com.phoenix.wechat.model.message.normal.VoiceInputMessage;
import com.phoenix.wechat.model.message.OutputMessage;

/**
 * <p>
 * Title: 微信公众平台接受消息处理器</p>
 *
 * <p>
 * Description: 接受消息分8类，普通消息（1.文本消息、2.图片消息、3.语音消息
 * 、4.视频消息、5.地理位置消息、6.链接消息）
 * 事件推送（1.关注/取消关注事件、2.扫描带二维码参数事件、3.上报地理位置事件、4.自定义
 * 菜单事件、5.点击菜单拉取消息时事件推送、6.点击菜单跳转链接时的事件推送</p>
 *
 * @since 0.0.6
 */
public interface INormalMessageHandler {

    /**
     * 文字内容的消息处理
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage textTypeMsg(TextInputMessage msg);

    /**
     * 图片类型的消息处理
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage imageTypeMsg(ImageInputMessage msg);

    /**
     * 语音类型的消息处理
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage voiceTypeMsg(VoiceInputMessage msg);

    /**
     * 视频类型的消息处理
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage videoTypeMsg(VideoInputMessage msg);

    /**
     * 小视频类型的消息处理
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage shortvideoTypeMsg(ShortVideoInputMessage msg);

    /**
     * 地理位置类型的消息处理
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage locationTypeMsg(LocationInputMessage msg);

    /**
     * 链接类型的消息处理
     *
     * @param msg 接受消息对象
     * @return 输出消息对象
     */
    public OutputMessage linkTypeMsg(LinkInputMessage msg);
}
