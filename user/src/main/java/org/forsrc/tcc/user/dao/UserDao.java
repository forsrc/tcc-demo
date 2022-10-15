package org.forsrc.tcc.user.dao;

import org.forsrc.tcc.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserDao extends BaseDao<User, Long> {

    @EntityGraph(type = EntityGraphType.FETCH, attributePaths = { "balance"})
    Page<User> findAll(Pageable pageable);
}