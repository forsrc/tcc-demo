package org.forsrc.tcc.user.dao;

import org.forsrc.tcc.user.entity.Balance;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "balance", path = "balance")
public interface BalanceDao extends BaseDao<Balance, Long> {

    public Balance findByUserId(Long userId);
}