package org.forsrc.tcc.common.service;

import org.forsrc.tcc.common.exception.TccException;

public interface TccService<T, PK> {

    PK tccTry(T t) throws TccException;

    void confirm(PK id) throws TccException;

    void cancel(PK id) throws TccException;
}
