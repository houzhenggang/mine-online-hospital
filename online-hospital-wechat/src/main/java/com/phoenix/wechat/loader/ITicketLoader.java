package com.phoenix.wechat.loader;

import com.phoenix.wechat.model.js.Ticket;
import com.phoenix.wechat.model.js.TicketType;

/**
 * JsApiTicket加载接口
 *
 * @since 0.1.0
 */
public interface ITicketLoader {

    /**
     * 获取Ticket
     *
     * @param ticketType 临时凭证类型
     * @see TicketType
     * @return 有效的ticket，若返回""或null，则触发重新从微信请求Ticket的方法refresh
     */
    Ticket get(TicketType ticketType);

    /**
     * 刷新Ticket
     *
     * @param ticket 包含ticket数据的对象
     */
    void refresh(Ticket ticket);
}
