package org.forsrc.tcc.user.controller;

import org.forsrc.core.controller.BaseController;
import org.forsrc.core.service.BaseService;
import org.forsrc.tcc.user.entity.User;
import org.forsrc.tcc.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserController extends BaseController<User, Long> {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserService userService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Override
    public BaseService<User, Long> getService() {
        return userService;
    }

}
