package org.forsrc.tcc.common.tcc.dto;

import java.util.Date;

public class TccInfoDto implements java.io.Serializable {

    private static final long serialVersionUID = -3603568859174762821L;

    private Long id;

    private String type;

    private String key;

    private String value;

    private Long userId;

    private Long referenceId;

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TccInfoDto [id=" + id + ", type=" + type + ", key=" + key + ", value=" + value + ", userId=" + userId
                + ", referenceId=" + referenceId + ", expire=" + expire + ", version=" + version + ", status=" + status
                + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
    }

}