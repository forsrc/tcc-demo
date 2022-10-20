package org.forsrc.tcc.tcc.service;

import org.forsrc.core.service.BaseService;
import org.forsrc.tcc.tcc.entity.TccInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = { Exception.class })
public interface TccInfoService extends BaseService<TccInfo, Long> {

    public void deleteByTccLinkId(Long tccLinkId);

}