package org.forsrc.tcc.user.service;

import org.forsrc.tcc.common.service.TccService;
import org.forsrc.tcc.user.entity.Balance;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = { Exception.class })
public interface BalanceUpdateTccService extends TccService<Balance, Long> {

}
