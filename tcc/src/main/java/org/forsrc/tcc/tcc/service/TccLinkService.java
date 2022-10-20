package org.forsrc.tcc.tcc.service;

import org.forsrc.core.service.BaseService;
import org.forsrc.tcc.tcc.entity.TccLink;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = { Exception.class })
public interface TccLinkService extends BaseService<TccLink, Long> {

    public void deleteByTccId(Long tccId);
}
