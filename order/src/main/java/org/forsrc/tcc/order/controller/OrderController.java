package org.forsrc.tcc.order.controller;

import org.forsrc.core.controller.BaseController;
import org.forsrc.core.service.BaseService;
import org.forsrc.tcc.order.entity.Order;
import org.forsrc.tcc.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(path = "/api/v1/order")
public class OrderController extends BaseController<Order, Long> {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OrderService orderService;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Override
    public BaseService<Order, Long> getService() {
        return orderService;
    }

}
