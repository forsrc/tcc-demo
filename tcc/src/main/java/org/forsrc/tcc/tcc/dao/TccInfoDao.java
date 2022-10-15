package org.forsrc.tcc.tcc.dao;

import org.forsrc.tcc.tcc.entity.TccInfo;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "tccInfo", path = "tccInfo")
public interface TccInfoDao extends BaseDao<TccInfo, Long> {

    public void deleteByTccLinkId(Long tccLinkId);

}