package org.forsrc.tcc.user.service.impl;

import java.math.BigDecimal;

import org.forsrc.tcc.user.dao.BalanceDao;
import org.forsrc.tcc.user.dao.BaseDao;
import org.forsrc.tcc.user.entity.Balance;
import org.forsrc.tcc.user.entity.TccInfo;
import org.forsrc.tcc.user.entity.User;
import org.forsrc.tcc.user.service.BalanceService;
import org.forsrc.tcc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = { Exception.class })
public class BalanceServiceImpl extends BaseServiceImpl<Balance, Long> implements BalanceService {

    @Autowired
    private BalanceDao dao;

    @Autowired
    private UserService userService;

    @Override
    public BaseDao<Balance, Long> getDao() {
        return dao;
    }

    @Override
    public Balance findByUserId(Long userId) {
        return dao.findByUserId(userId);
    }

    @Override
    public void updateBalance(TccInfo tccInfo) {
        User user = userService.getById(tccInfo.getId());
        Balance balance = user.getBalance();
        BigDecimal balanceBigDecimal = new BigDecimal(tccInfo.getValue());
        BigDecimal newBalance = balance.getBalance().add(balanceBigDecimal);
        balance.setBalance(newBalance);
        dao.save(balance);
    }

}
