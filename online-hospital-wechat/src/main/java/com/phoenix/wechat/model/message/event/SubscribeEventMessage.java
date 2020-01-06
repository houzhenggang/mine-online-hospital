package com.phoenix.wechat.model.message.event;

import com.phoenix.wechat.model.message.EventType;

/**
 * 关注事件
 *
 * @since 0.0.1
 */
public class SubscribeEventMessage extends EventMessage {

    @Override
    public String getEvent() {
        return EventType.Subscribe.toString();
    }

}
