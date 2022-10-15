package org.forsrc.tcc.tcc.controller;

import java.util.Set;

import org.forsrc.tcc.tcc.entity.Tcc;
import org.forsrc.tcc.tcc.entity.TccInfo;
import org.forsrc.tcc.tcc.entity.TccLink;
import org.forsrc.tcc.tcc.service.BaseService;
import org.forsrc.tcc.tcc.service.TccService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(path = "/api/v1/tcc")
public class TccController extends BaseController<Tcc, Long> {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TccService service;

    private static final Logger LOGGER = LoggerFactory.getLogger(TccController.class);

    @Override
    public BaseService<Tcc, Long> getService() {
        return service;
    }

    @PostMapping("/")
    public ResponseEntity<Tcc> tcc(@RequestBody Tcc t) {
        Assert.notNull(t, "save: Object is null");
        LOGGER.info("-->\tttc({})", t);
        Tcc tcc = service.save(t);
        LOGGER.info("-->\ttcc() : {}", tcc);
        Set<TccLink> tccLinkList = tcc.getTccLinkSet();
        for (TccLink tccLink : tccLinkList) {
            Set<TccInfo> tccInfoList = tccLink.getTccInfoSet();
            for (TccInfo tccInfo : tccInfoList) {
                try {
                    ResponseEntity<Long> result = restTemplate.postForEntity(tccLink.getUri() + "/try", tccInfo,
                            Long.class);
                } catch (HttpStatusCodeException e) {
                    throw e;
                }
            }
        }

        return new ResponseEntity<>(tcc, HttpStatus.OK);
    }

}
