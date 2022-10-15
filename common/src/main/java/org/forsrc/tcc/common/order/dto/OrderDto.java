package org.forsrc.tcc.common.order.dto;

import java.util.Date;

public class OrderDto implements java.io.Serializable {

    private static final long serialVersionUID = -3603568859174762821L;

    private Long id;

    private Long userId;

    private Double money;

    private Date expire;

    private int version;

    private Integer status;

    private Date createAt;

    private Date updateAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", userId=" + userId + ", money=" + money + ", expire=" + expire + ", version="
                + version + ", status=" + status + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
    }

}