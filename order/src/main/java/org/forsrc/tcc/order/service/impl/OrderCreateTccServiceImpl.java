package org.forsrc.tcc.order.service.impl;

import org.forsrc.tcc.common.exception.TccException;
import org.forsrc.tcc.common.service.TccService;
import org.forsrc.tcc.common.status.TccStatus;
import org.forsrc.tcc.order.dao.OrderDao;
import org.forsrc.tcc.order.entity.Order;
import org.forsrc.tcc.order.entity.TccInfo;
import org.forsrc.tcc.order.service.OrderCreateTccService;
import org.forsrc.tcc.order.service.TccInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderCreateTccServiceImpl implements OrderCreateTccService, TccService<Order, Long> {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private TccInfoService tccInfoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Long tccTry(Order order) throws TccException {

        TccInfo tccInfo = new TccInfo();
        tccInfo.setUserId(order.getUserId());
        try {
            tccInfo.setValue(objectMapper.writeValueAsString(order));
        } catch (JsonProcessingException e) {
            throw new TccException(null, null, TccStatus.TRY);
        }
        tccInfo = tccInfoService.save(tccInfo);
        return tccInfo.getId();
    }

    @Override
    public void confirm(Long id) throws TccException {
        TccInfo tccInfo = tccInfoService.getById(id);
        try {
            Order order = objectMapper.readValue(tccInfo.getValue(), Order.class);
            orderDao.save(order);
            tccInfo.setStatus(TccStatus.CONFIRM.getStatus());
            tccInfoService.save(tccInfo);
        } catch (JsonProcessingException e) {
            tccInfo.setStatus(TccStatus.CONFIRM_CANCEL.getStatus());
            tccInfoService.save(tccInfo);
            throw new TccException(id, null, TccStatus.TRY);
        }

    }

    @Override
    public void cancel(Long id) throws TccException {
        TccInfo tccInfo = tccInfoService.getById(id);
        tccInfo.setStatus(TccStatus.CANCEL.getStatus());
        tccInfo = tccInfoService.save(tccInfo);

    }

}
