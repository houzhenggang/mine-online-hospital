package com.phoenix.wechat.model.message.event;

import com.phoenix.wechat.model.message.EventType;

/**
 * 取消关注事件
 *
 * @since 0.0.1
 */
public class UnSubscribeEventMessage extends EventMessage {

    @Override
    public String getEvent() {
        return EventType.Unsubscribe.toString();
    }

}
