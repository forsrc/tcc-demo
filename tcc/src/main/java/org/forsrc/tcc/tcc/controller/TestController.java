package org.forsrc.tcc.tcc.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.forsrc.tcc.common.tcc.dto.TccDto;
import org.forsrc.tcc.common.tcc.dto.TccInfoDto;
import org.forsrc.tcc.common.tcc.dto.TccLinkDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(path = "/api/v1/test")
public class TestController {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${my.tcc.url}")
    private String tccUrl;

    @Value("${my.user.url}")
    private String userUrl;

    @Value("${my.order.url}")
    private String orderUrl;


    @GetMapping("")
    public ResponseEntity<TccDto> test() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 10);
        Date date = calendar.getTime();

        List<TccLinkDto> list = new ArrayList<>();

        TccLinkDto userTccLinkDto = new TccLinkDto();
        userTccLinkDto.setExpire(date);
        userTccLinkDto.setReferenceId(1L);
        userTccLinkDto.setStatus(0);
        userTccLinkDto.setUri(userUrl + "/api/v1/updateBalance");

        TccInfoDto userTccInfoDto = new TccInfoDto();
        userTccInfoDto.setUserId(1L);
        userTccInfoDto.setType("update_balance");
        userTccInfoDto.setKey("balance");
        userTccInfoDto.setValue("-10.00");
        userTccInfoDto.setExpire(date);
        userTccInfoDto.setStatus(0);

        List<TccInfoDto> userTccInfoList = new ArrayList<>();
        userTccInfoList.add(userTccInfoDto);
        userTccLinkDto.setTccInfoList(userTccInfoList);

        //
        TccLinkDto orderTccLinkDto = new TccLinkDto();
        orderTccLinkDto.setExpire(date);
        orderTccLinkDto.setReferenceId(1L);
        orderTccLinkDto.setStatus(0);
        orderTccLinkDto.setUri(orderUrl + "/api/v1/createOrder");

        TccInfoDto orderTccInfoDto = new TccInfoDto();
        orderTccInfoDto.setUserId(1L);
        orderTccInfoDto.setType("create_order");
        orderTccInfoDto.setKey("money");
        orderTccInfoDto.setValue("10.00");
        orderTccInfoDto.setExpire(date);
        orderTccInfoDto.setStatus(0);

        List<TccInfoDto> orderTccInfoList = new ArrayList<>();
        orderTccInfoList.add(orderTccInfoDto);
        orderTccLinkDto.setTccInfoList(orderTccInfoList);

        //
        list.add(userTccLinkDto);
        list.add(orderTccLinkDto);

        TccDto tccDto = new TccDto();
        tccDto.setExpire(date);
        tccDto.setTimes(0);
        tccDto.setStatus(0);
        tccDto.setMicroservice(context.getApplicationName());
        tccDto.setTccLinkList(list);

        ResponseEntity<TccDto> result = null;
        try {
            result = restTemplate.postForEntity(tccUrl + "/api/v1/tcc/", tccDto, TccDto.class);

        } catch (HttpStatusCodeException e) {
            throw e;
        }

        return new ResponseEntity<>(result.getBody(), HttpStatus.OK);
    }
}
