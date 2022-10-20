package org.forsrc.tcc.user.service.impl;

import org.forsrc.core.dao.BaseDao;
import org.forsrc.core.service.impl.BaseServiceImpl;
import org.forsrc.tcc.user.dao.UserDao;
import org.forsrc.tcc.user.entity.User;
import org.forsrc.tcc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = { Exception.class })
public class UserServiceImpl extends BaseServiceImpl<User, Long> implements UserService {

    @Autowired
    private UserDao dao;

    @Override
    public BaseDao<User, Long> getDao() {
        return dao;
    }

}
