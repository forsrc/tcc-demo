package org.forsrc.tcc.common.status;

public enum TccStatus {
    NONE(0), // none
    TRYING(1), // trying
    TRY(2), CONFIRMING(3), // confirming
    CONFIRM(4), // confirm
    CANCELING(5), // canceling
    CANCEL(6), // cancel
    TRYING_CANCEL(7), // trying to cancel
    TRY_CANCEL(8), // try to cancel
    CONFIRMING_CANCEL(9), // confirming to cancel
    CONFIRM_CANCEL(10), // confirm to cancel
    EXPIRED(11);

    private int status = 0;

    TccStatus(int status) {

        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public TccStatus valueOf(int status) {
        for (TccStatus tccStatus : TccStatus.values()) {
            if (tccStatus.getStatus() == status) {
                return tccStatus;
            }
        }

        return TccStatus.NONE;
    }
}
