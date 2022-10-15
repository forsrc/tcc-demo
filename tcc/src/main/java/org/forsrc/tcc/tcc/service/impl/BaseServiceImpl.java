package org.forsrc.tcc.tcc.service.impl;

import java.util.List;

import org.forsrc.tcc.tcc.dao.BaseDao;
import org.forsrc.tcc.tcc.service.BaseService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = { Exception.class })
public abstract class BaseServiceImpl<E, PK> implements BaseService<E, PK> {

    public abstract BaseDao<E, PK> getDao();

    @Override
    public E save(E e) {
        return getDao().save(e);
    }

    @Override
    public E update(E e) {
        return getDao().save(e);
    }

    @Override
    @Transactional(readOnly = true)
    public E getById(PK pk) {
        return getDao().getReferenceById(pk);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<E> get(int page, int size) {
        Page<E> p = getDao().findAll(PageRequest.of(page, size));
        return p;
    }

    @Override
    public void deleteById(PK pk) {
        getDao().deleteById(pk);
    }

    @Override
    public void delete(E e) {
        getDao().delete(e);
    }

    @Override
    public List<E> findAll(E e) {

        return getDao().findAll(Example.of(e));
    }
}
