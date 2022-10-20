package org.forsrc.tcc.order.service.impl;

import org.forsrc.core.dao.BaseDao;
import org.forsrc.core.service.impl.BaseServiceImpl;
import org.forsrc.tcc.order.dao.TccInfoDao;
import org.forsrc.tcc.order.entity.TccInfo;
import org.forsrc.tcc.order.service.TccInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = { Exception.class })
public class TccInfoServiceImpl extends BaseServiceImpl<TccInfo, Long> implements TccInfoService {

    @Autowired
    private TccInfoDao dao;

    @Override
    public BaseDao<TccInfo, Long> getDao() {
        return dao;
    }

}
