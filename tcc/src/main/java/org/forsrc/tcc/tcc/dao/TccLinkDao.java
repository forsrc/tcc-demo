package org.forsrc.tcc.tcc.dao;

import org.forsrc.core.dao.BaseDao;
import org.forsrc.tcc.tcc.entity.TccLink;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "tccLink", path = "tccLink")
public interface TccLinkDao extends BaseDao<TccLink, Long> {
    public void deleteByTccId(Long tccId);
}