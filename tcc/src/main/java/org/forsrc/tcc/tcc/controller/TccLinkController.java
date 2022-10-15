package org.forsrc.tcc.tcc.controller;

import org.forsrc.tcc.tcc.entity.TccLink;
import org.forsrc.tcc.tcc.service.BaseService;
import org.forsrc.tcc.tcc.service.TccLinkService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(path = "/api/v1/tccLink")
public class TccLinkController extends BaseController<TccLink, Long> {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TccLinkService service;

    private static final Logger LOGGER = LoggerFactory.getLogger(TccLinkController.class);

    @Override
    public BaseService<TccLink, Long> getService() {
        return service;
    }

}
