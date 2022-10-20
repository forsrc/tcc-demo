package org.forsrc.tcc.user.service.impl;

import org.forsrc.core.dao.BaseDao;
import org.forsrc.core.service.impl.BaseServiceImpl;
import org.forsrc.tcc.user.dao.TccInfoDao;
import org.forsrc.tcc.user.entity.TccInfo;
import org.forsrc.tcc.user.service.TccInfoService;
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
