package org.forsrc.tcc.user.controller;

import org.forsrc.core.controller.BaseController;
import org.forsrc.core.service.BaseService;
import org.forsrc.tcc.user.entity.Balance;
import org.forsrc.tcc.user.service.BalanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(path = "/api/v1/balance")
public class BalanceController extends BaseController<Balance, Long> {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private BalanceService service;

    private static final Logger LOGGER = LoggerFactory.getLogger(BalanceController.class);

    @Override
    public BaseService<Balance, Long> getService() {
        return service;
    }

}
