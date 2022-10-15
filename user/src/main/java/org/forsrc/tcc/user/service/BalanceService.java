package org.forsrc.tcc.user.service;

import org.forsrc.tcc.user.entity.Balance;
import org.forsrc.tcc.user.entity.TccInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = { Exception.class })
public interface BalanceService extends BaseService<Balance, Long> {

    public Balance findByUserId(Long userId);

    public void updateBalance(TccInfo tccInfo);

}
