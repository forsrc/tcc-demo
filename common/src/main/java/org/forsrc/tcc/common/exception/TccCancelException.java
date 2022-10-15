package org.forsrc.tcc.common.exception;

import org.forsrc.tcc.common.status.TccStatus;

public class TccCancelException extends TccException {

    private static final long serialVersionUID = -7540498410823440508L;

    protected Long id;

    protected TccStatus status;

    public TccCancelException(Long id, String message, TccStatus status) {
        super(id, message, status);
    }

}
