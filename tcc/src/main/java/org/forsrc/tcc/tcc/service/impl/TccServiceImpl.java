package org.forsrc.tcc.tcc.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.forsrc.tcc.tcc.dao.BaseDao;
import org.forsrc.tcc.tcc.dao.TccDao;
import org.forsrc.tcc.tcc.dao.TccInfoDao;
import org.forsrc.tcc.tcc.dao.TccLinkDao;
import org.forsrc.tcc.tcc.entity.Tcc;
import org.forsrc.tcc.tcc.entity.TccInfo;
import org.forsrc.tcc.tcc.entity.TccLink;
import org.forsrc.tcc.tcc.service.TccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = { Exception.class })
public class TccServiceImpl extends BaseServiceImpl<Tcc, Long> implements TccService {

    @Autowired
    private TccDao dao;

    @Autowired
    private TccLinkDao tccLinkDao;

    @Autowired
    private TccInfoDao tccInfoDao;

    @Override
    public BaseDao<Tcc, Long> getDao() {
        return dao;
    }

    public Tcc _save(Tcc tcc) {
        Set<TccLink> tccLinkSet= tcc.getTccLinkSet();
        tcc.setTccLinkSet(new HashSet<>(0));
        Tcc savedTcc = dao.save(tcc);
        Long tccId = savedTcc.getId();

        if (tccLinkSet != null && tccLinkSet.size() > 0) {
            Set<TccLink> savedTccLinkSet = new HashSet<>();
            for (TccLink tccLink : tccLinkSet) {
                Set<TccInfo> tccInfoSet = tccLink.getTccInfoSet();
                tccLink.setTccId(tccId);
                tccLink.setTccInfoSet(new HashSet<>(0));
                TccLink savedTccLink = tccLinkDao.save(tccLink);
                if (tccInfoSet != null && tccInfoSet.size() > 0) {
                    Set<TccInfo> savedTccInfoSet = new HashSet<>();
                    for (TccInfo tccInfo : tccInfoSet) {
                        tccInfo.setTccLinkId(savedTccLink.getId());
                        TccInfo savedTccInfo = tccInfoDao.save(tccInfo);
                        savedTccInfoSet.add(savedTccInfo);
                    }
                    savedTccLink.setTccInfoSet(savedTccInfoSet);
                }
                //
                savedTccLinkSet.add(savedTccLink);
            }
            savedTcc.setTccLinkSet(savedTccLinkSet);
        }

        return savedTcc;
    }

    @Override
    public Tcc save(Tcc tcc) {
        Tcc savedTcc = dao.save(tcc);
        return savedTcc;
    }

    public Tcc _update(Tcc tcc) {
        Set<TccLink> tccLinkSet = tcc.getTccLinkSet();
        tcc.setTccLinkSet(new HashSet<>(0));
        Tcc savedTcc = dao.save(tcc);
        Long tccId = savedTcc.getId();

        if (tccLinkSet != null && tccLinkSet.size() > 0) {
            tccLinkDao.deleteByTccId(tccId);
            Set<TccLink> savedTccLinkSet = new HashSet<>();
            for (TccLink tccLink : tccLinkSet) {
                Long tccLinkId = tccLink.getId();
                Set<TccInfo> tccInfoSet = tccLink.getTccInfoSet();
                tccLink.setTccId(tccId);
                tccLink.setTccInfoSet(new HashSet<>(0));
                TccLink savedTccLink = tccLinkDao.save(tccLink);
                if (tccInfoSet != null && tccInfoSet.size() > 0) {
                    tccInfoDao.deleteByTccLinkId(tccLinkId);
                    Set<TccInfo> savedTccInfoSet = new HashSet<>();
                    for (TccInfo tccInfo : tccInfoSet) {
                        tccInfo.setTccLinkId(savedTccLink.getId());
                        TccInfo savedTccInfo = tccInfoDao.save(tccInfo);
                        savedTccInfoSet.add(savedTccInfo);
                    }
                    savedTccLink.setTccInfoSet(savedTccInfoSet);
                }
                savedTccLinkSet.add(savedTccLink);
            }
            savedTcc.setTccLinkSet(savedTccLinkSet);
        }

        return savedTcc;
    }

    @Override
    public Tcc tcc(Tcc e) {
        Tcc tcc = save(e);
        return tcc;
    }
}
