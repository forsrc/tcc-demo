package org.forsrc.tcc.common.user.dto;

import java.math.BigDecimal;
import java.util.Date;

public class BalanceDto implements java.io.Serializable {

    private static final long serialVersionUID = 7053075402341362549L;

    private Long id;

    private Long userId;

    private BigDecimal balance;

    private Integer enabled;

    private Date createAt;

    private Date updateAt;

    private int version;

    private int status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BalanceDto [id=" + id + ", userId=" + userId + ", balance=" + balance + ", enabled=" + enabled
                + ", createAt=" + createAt + ", updateAt=" + updateAt + ", version=" + version + ", status=" + status
                + "]";
    }

}