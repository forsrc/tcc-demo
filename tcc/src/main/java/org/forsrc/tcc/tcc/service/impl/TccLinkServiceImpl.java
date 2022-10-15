package org.forsrc.tcc.tcc.service.impl;

import org.forsrc.tcc.tcc.dao.BaseDao;
import org.forsrc.tcc.tcc.dao.TccLinkDao;
import org.forsrc.tcc.tcc.entity.TccLink;
import org.forsrc.tcc.tcc.service.TccLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = { Exception.class })
public class TccLinkServiceImpl extends BaseServiceImpl<TccLink, Long> implements TccLinkService {

    @Autowired
    private TccLinkDao dao;

    @Override
    public BaseDao<TccLink, Long> getDao() {
        return dao;
    }

    @Override
    public void deleteByTccId(Long tccId) {
        dao.deleteByTccId(tccId);
    }
}
