package org.forsrc.tcc.common.tcc.dto;

import java.util.Date;
import java.util.List;

public class TccDto implements java.io.Serializable {

    private static final long serialVersionUID = 4706144731706609711L;

    private Long id;

    private Date expire;

    private Integer status;

    private Integer times;

    private String microservice;

    private int version;

    private Date createAt;

    private Date updateAt;

    private List<TccLinkDto> tccLinkList;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public List<TccLinkDto> getTccLinkList() {
        return tccLinkList;
    }

    public void setTccLinkList(List<TccLinkDto> tccLinkList) {
        this.tccLinkList = tccLinkList;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getMicroservice() {
        return microservice;
    }

    public void setMicroservice(String microservice) {
        this.microservice = microservice;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "TccDto [id=" + id + ", expire=" + expire + ", status=" + status + ", times=" + times + ", microservice="
                + microservice + ", version=" + version + ", createAt=" + createAt + ", updateAt=" + updateAt
                + ", tccLinkList=" + tccLinkList + "]";
    }

}