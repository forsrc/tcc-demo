package org.forsrc.core.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = { Exception.class })
public interface BaseService<E, PK> {

    public E getById(PK pk);

    public E save(E e);

    public E update(E user);

    public Page<E> get(int page, int size);

    public void deleteById(PK pk);

    public void delete(E e);

    public List<E> findAll(E e);

}