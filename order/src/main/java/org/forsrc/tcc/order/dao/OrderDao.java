package org.forsrc.tcc.order.dao;

import org.forsrc.tcc.order.entity.Order;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "order", path = "order")
public interface OrderDao extends BaseDao<Order, Long> {

}