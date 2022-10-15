package org.forsrc.tcc.user.dao;

import org.forsrc.tcc.user.entity.TccInfo;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "tccInfo", path = "tccInfo")
public interface TccInfoDao extends BaseDao<TccInfo, Long> {

}