package org.forsrc.tcc.tcc.dao;

import org.forsrc.tcc.tcc.entity.Tcc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "tcc", path = "tcc")
public interface TccDao extends BaseDao<Tcc, Long> {

    //@EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "tccLinkSet"})
    @EntityGraph(value = "neg_tcc", type = EntityGraphType.FETCH)
    Page<Tcc> findAll(Pageable pageable);
}