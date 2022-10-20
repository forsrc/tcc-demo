package org.forsrc.tcc.user.service;

import org.forsrc.core.service.BaseService;
import org.forsrc.tcc.user.entity.TccInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = { Exception.class })
public interface TccInfoService extends BaseService<TccInfo, Long> {

}