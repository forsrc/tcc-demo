package org.forsrc.tcc.tcc.service;

import org.forsrc.core.service.BaseService;
import org.forsrc.tcc.tcc.entity.Tcc;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = { Exception.class })
public interface TccService extends BaseService<Tcc, Long> {

    public Tcc tcc(Tcc e);
}
