package org.forsrc.tcc.tcc.aop;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionControllerAdvice {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @RequestMapping(produces = { "application/json" })
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> exception(HttpServletRequest request, HttpServletResponse response,
            Exception e) {
        LOGGER.error("--> Exception {} : {}", request.getRequestURI(), e.getMessage());
        e.printStackTrace();
        Map<String, Object> map = new HashMap<>(3);
        map.put("uri", request.getRequestURI());
        map.put("queryString", request.getQueryString());
        map.put("message", e.getMessage());
        map.put("exception", e.getClass());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(map, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
