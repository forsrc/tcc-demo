package org.forsrc.tcc.user.controller;

import org.forsrc.tcc.common.api.TccWebApi;
import org.forsrc.tcc.common.exception.TccException;
import org.forsrc.tcc.common.order.dto.OrderDto;
import org.forsrc.tcc.user.entity.Balance;
import org.forsrc.tcc.user.service.BalanceUpdateTccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/balance/update/tcc")
public class BalanceUpdateTccController implements TccWebApi<Balance, Long> {

    @Autowired
    private BalanceUpdateTccService balanceUpdateTccService;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<OrderDto> list() throws TccException {

        return null;
    }

    @Override
    @RequestMapping(value = "/try", method = RequestMethod.POST)
    public ResponseEntity<Long> tccTry(Balance dto) throws TccException {
        return ResponseEntity.ok(balanceUpdateTccService.tccTry(dto));
    }

    @Override
    @RequestMapping(value = "/confirm/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> confirm(Long id) throws TccException {
        balanceUpdateTccService.confirm(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @RequestMapping(value = "/cancel/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> cancel(Long id) throws TccException {
        balanceUpdateTccService.cancel(id);
        return ResponseEntity.ok().build();
    }

}
