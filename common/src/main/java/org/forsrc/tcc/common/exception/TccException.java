package org.forsrc.tcc.common.exception;

import org.forsrc.tcc.common.status.TccStatus;

public class TccException extends Exception {

    private static final long serialVersionUID = -7540498410823440508L;

    protected Long id;

    protected TccStatus status;

    public TccException(Long id, String message, TccStatus status) {
        super(message);
        this.id = id;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TccStatus getStatus() {
        return status;
    }

    public void setStatus(TccStatus status) {
        this.status = status;
    }

}
