package com.phoenix.wechat.loader;

import java.util.EnumMap;
import java.util.Map;

import com.phoenix.wechat.model.js.Ticket;
import org.apache.commons.lang3.StringUtils;

import com.phoenix.wechat.model.js.TicketType;

/**
 * 内存式Ticket存储器
 *
 * 单项目时使用（生产环境不推荐）
 *
 * @since 0.1.0
 */
public class DefaultTicketLoader implements ITicketLoader {

    private final Map<TicketType, Ticket> tickets = new EnumMap<TicketType, Ticket>(TicketType.class);

    @Override
    public Ticket get(TicketType ticketType) {
        Ticket ticket = tickets.get(ticketType);
        return (ticket == null
                || StringUtils.isEmpty(ticket.getTicket())
                || ticket.isExprexpired()) ? null : ticket;
    }

    @Override
    public void refresh(Ticket ticket) {
        tickets.put(ticket.getTicketType(), ticket);
    }

}
