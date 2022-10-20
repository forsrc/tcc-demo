package org.forsrc.tcc.order.service;

import org.forsrc.core.service.BaseService;
import org.forsrc.tcc.order.entity.TccInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = { Exception.class })
public interface TccInfoService extends BaseService<TccInfo, Long> {

}