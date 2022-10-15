package org.forsrc.tcc.order.controller;

import org.forsrc.tcc.common.api.TccWebApi;
import org.forsrc.tcc.common.exception.TccException;
import org.forsrc.tcc.common.order.dto.OrderDto;
import org.forsrc.tcc.order.entity.Order;
import org.forsrc.tcc.order.service.OrderCreateTccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/order/create/tcc")
public class OrederCreateTccController implements TccWebApi<Order, Long> {

    @Autowired
    private OrderCreateTccService orderTccService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<OrderDto> list() throws TccException {

        return null;
    }

    @Override
    @RequestMapping(value = "/try", method = RequestMethod.POST)
    public ResponseEntity<Long> tccTry(Order dto) throws TccException {
        return ResponseEntity.ok(orderTccService.tccTry(dto));
    }

    @Override
    @RequestMapping(value = "/confirm/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> confirm(Long id) throws TccException {
        orderTccService.confirm(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @RequestMapping(value = "/cancel/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> cancel(Long id) throws TccException {
        orderTccService.cancel(id);
        return ResponseEntity.ok().build();
    }

}
