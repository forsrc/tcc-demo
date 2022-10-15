package org.forsrc.tcc.order.service;

import org.forsrc.tcc.order.entity.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = { Exception.class })
public interface OrderService extends BaseService<Order, Long> {

}
