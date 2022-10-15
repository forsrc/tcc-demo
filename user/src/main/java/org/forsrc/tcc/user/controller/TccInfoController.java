package org.forsrc.tcc.user.controller;

import org.forsrc.tcc.common.api.TccWebApi;
import org.forsrc.tcc.common.exception.TccException;
import org.forsrc.tcc.user.entity.TccInfo;
import org.forsrc.tcc.user.service.BalanceService;
import org.forsrc.tcc.user.service.BaseService;
import org.forsrc.tcc.user.service.TccInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(path = "/api/v1/updateBalance")
public class TccInfoController extends BaseController<TccInfo, Long> implements TccWebApi<TccInfo, Long> {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TccInfoService tccInfoService;

    @Autowired
    private BalanceService balanceService;

    private static final Logger LOGGER = LoggerFactory.getLogger(TccInfoController.class);

    @Override
    public BaseService<TccInfo, Long> getService() {
        return tccInfoService;
    }

    @RequestMapping(value = "/try", method = RequestMethod.POST)
    public ResponseEntity<Long> tccTry(@RequestBody TccInfo t) throws TccException {

        LOGGER.info("-->\ttry({})", t);
        t = tccInfoService.save(t);
        LOGGER.info("-->\ttry() : {}", t);
        return null;
    }

    @RequestMapping(value = "/confirm/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> confirm(@PathVariable("id") Long id) throws TccException {

        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/cancel/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> cancel(@PathVariable("id") Long id) throws TccException {

        return ResponseEntity.ok().build();
    }

}
