package org.forsrc.tcc.user.service.impl;

import java.math.BigDecimal;

import org.forsrc.tcc.common.exception.TccException;
import org.forsrc.tcc.common.status.TccStatus;
import org.forsrc.tcc.user.dao.BalanceDao;
import org.forsrc.tcc.user.entity.Balance;
import org.forsrc.tcc.user.entity.TccInfo;
import org.forsrc.tcc.user.entity.User;
import org.forsrc.tcc.user.service.BalanceUpdateTccService;
import org.forsrc.tcc.user.service.TccInfoService;
import org.forsrc.tcc.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional(rollbackFor = { Exception.class })
public class BalanceUpdateTccServiceImpl implements BalanceUpdateTccService {

    @Autowired
    private BalanceDao dao;

    @Autowired
    private UserService userService;

    @Autowired
    private TccInfoService tccInfoService;
    
    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public Long tccTry(Balance balance) throws TccException {
        TccInfo tccInfo = new TccInfo();
        tccInfo.setUserId(balance.getUserId());
        try {
            tccInfo.setValue(objectMapper.writeValueAsString(balance));
        } catch (JsonProcessingException e) {
            throw new TccException(balance.getId(), null, TccStatus.TRY);
        }
        tccInfo.setStatus(TccStatus.TRY.getStatus());
        tccInfo = tccInfoService.save(tccInfo);
        return tccInfo.getId();
    }

    @Override
    public void confirm(Long id) throws TccException {
        TccInfo tccInfo = tccInfoService.getById(id);
        User user = userService.getById(tccInfo.getId());
        Balance balance = user.getBalance();
        try {
            Balance tccBalance = objectMapper.readValue(tccInfo.getValue(), Balance.class);
            BigDecimal balanceBigDecimal = tccBalance.getBalance();
            BigDecimal newBalance = balance.getBalance().add(balanceBigDecimal);
            balance.setBalance(newBalance);
            dao.save(balance);

            tccInfo.setStatus(TccStatus.CONFIRM.getStatus());
            tccInfoService.save(tccInfo);

        } catch (JsonProcessingException e) {
            tccInfo.setStatus(TccStatus.CONFIRM_CANCEL.getStatus());
            tccInfoService.save(tccInfo);
            throw new TccException(id, null, TccStatus.TRY);
        }

    }

    @Override
    public void cancel(Long id) throws TccException {
        TccInfo tccInfo = tccInfoService.getById(id);
        tccInfo.setStatus(TccStatus.CANCEL.getStatus());
        tccInfo = tccInfoService.save(tccInfo);
    }

}
