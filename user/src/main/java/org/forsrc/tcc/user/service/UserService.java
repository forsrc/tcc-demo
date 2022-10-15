package org.forsrc.tcc.user.service;

import org.forsrc.tcc.user.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = { Exception.class })
public interface UserService extends BaseService<User, Long> {

}
