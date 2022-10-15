package org.forsrc.tcc.tcc.service.impl;

import org.forsrc.tcc.tcc.dao.BaseDao;
import org.forsrc.tcc.tcc.dao.TccInfoDao;
import org.forsrc.tcc.tcc.entity.TccInfo;
import org.forsrc.tcc.tcc.service.TccInfoService;
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

    @Override
    public void deleteByTccLinkId(Long tccLinkId) {
        dao.deleteByTccLinkId(tccLinkId);
    }

}
