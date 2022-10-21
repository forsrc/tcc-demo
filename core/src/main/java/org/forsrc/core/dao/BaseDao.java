package org.forsrc.core.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
@Repository
public interface BaseDao<E extends Serializable, PK> extends JpaRepository<E, PK>, PagingAndSortingRepository<E, PK> {

}