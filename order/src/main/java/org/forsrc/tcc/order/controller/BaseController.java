package org.forsrc.tcc.order.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.forsrc.tcc.order.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public abstract class BaseController<T extends Serializable, PK> {

    public abstract BaseService<T, PK> getService();

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @GetMapping("/{pk}")
    public ResponseEntity<T> get(@PathVariable("pk") PK pk) {
        T t = getService().getById(pk);
        LOGGER.info("-->\tgetById({}) : {}", pk, t);

        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<Page<T>> get(@RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "size", required = false) Integer size) {

        int pageValue = page == null || page == 0 ? 0 : page;
        int sizeValue = size == null || size == 0 ? 10 : size;
        sizeValue = sizeValue >= 100 ? 1 : sizeValue;
        Page<T> list = getService().get(pageValue, sizeValue);
        LOGGER.info("-->\tget({}, {}) : {}", pageValue, sizeValue, list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<T> save(@RequestBody T t) {
        Assert.notNull(t, "save: Object is null");
        LOGGER.info("-->\tsave({})", t);
        t = getService().save(t);
        LOGGER.info("-->\tsave() : {}", t);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<T> update(@RequestBody T t) {
        Assert.notNull(t, "update: Object is null");
        // Assert.notNull(user.getUsername(), "update: username is nul");
        LOGGER.info("-->\tupdate({})", t);
        t = getService().update(t);
        LOGGER.info("-->\tupdate() : {}", t);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @DeleteMapping("/{pk}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("pk") PK pk) {
        Assert.notNull(pk, "delete: pk is nul");
        LOGGER.info("-->\tdeleteById({})", pk);
        getService().deleteById(pk);
        Map<String, Object> message = new HashMap<>(1);
        message.put("message", "Deleted " + pk.toString());
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
