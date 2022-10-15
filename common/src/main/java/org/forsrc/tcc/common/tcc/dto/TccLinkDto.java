package org.forsrc.tcc.common.tcc.dto;

import java.util.Date;
import java.util.List;

public class TccLinkDto implements java.io.Serializable {

    private static final long serialVersionUID = -3603568859174762821L;

    private Long id;

    private Long tccId;

    private String uri;

    private Long referenceId;

    private Date createAt;

    private Date updateAt;

    private Date expire;

    private int version;

    private Integer status;

    private List<TccInfoDto> tccInfoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    public Long getTccId() {
        return tccId;
    }

    public void setTccId(Long tccId) {
        this.tccId = tccId;
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

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
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

    public List<TccInfoDto> getTccInfoList() {
        return tccInfoList;
    }

    public void setTccInfoList(List<TccInfoDto> tccInfoList) {
        this.tccInfoList = tccInfoList;
    }

    @Override
    public String toString() {
        return "TccLinkDto [id=" + id + ", tccId=" + tccId + ", uri=" + uri + ", referenceId=" + referenceId
                + ", createAt=" + createAt + ", updateAt=" + updateAt + ", expire=" + expire + ", version=" + version
                + ", status=" + status + ", tccInfoList=" + tccInfoList + "]";
    }

}