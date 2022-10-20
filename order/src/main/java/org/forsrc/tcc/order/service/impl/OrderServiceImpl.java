package org.forsrc.tcc.order.service.impl;

import java.util.List;

import org.forsrc.core.dao.BaseDao;
import org.forsrc.core.service.impl.BaseServiceImpl;
import org.forsrc.tcc.order.dao.OrderDao;
import org.forsrc.tcc.order.entity.Order;
import org.forsrc.tcc.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = { Exception.class })
public class OrderServiceImpl extends BaseServiceImpl<Order, Long> implements OrderService {

    @Autowired
    private OrderDao dao;

    @Override
    public BaseDao<Order, Long> getDao() {
        return dao;
    }

    @Override
    public List<Order> findAll(Order e) {

        return dao.findAll(Example.of(e));
    }

}
