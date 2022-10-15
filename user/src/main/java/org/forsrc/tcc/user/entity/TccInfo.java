package org.forsrc.tcc.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "t_tcc_info")
@JsonIgnoreProperties(value = { "tccLinkId" })
public class TccInfo implements java.io.Serializable {

    private static final long serialVersionUID = -3603568859174762821L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "type", nullable = false, columnDefinition = "VARCHAR(200)")
    private String type;

    @Column(name = "`key`", nullable = false, columnDefinition = "VARCHAR(200)")
    private String key;

    @Column(name = "`value`", nullable = false, columnDefinition = "TEXT")
    private String value;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "reference_id", nullable = true)
    private Long referenceId;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @Column(name = "expire", nullable = false, columnDefinition = "TIMESTAMP DEFAULT TIMESTAMPADD(MINUTE, 5, CURRENT_TIMESTAMP)")
    private Date expire;

    @Column(name = "version", insertable = false, updatable = true, nullable = false, columnDefinition = "INT DEFAULT 0")
    @Version
    private int version;

    @Column(name = "status", length = 2, nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer status;

    @Column(name = "create_at", insertable = false, updatable = false, nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date createAt;

    @PrePersist
    protected void onCreate() {
        this.createAt = new Date();
    }

    @Column(name = "update_at", insertable = false, updatable = true, nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date updateAt;

    @PreUpdate
    protected void onUpdate() {
        this.updateAt = new Date();
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    @Override
    public String toString() {
        return "TccInfo [id=" + id + ", type=" + type + ", key=" + key + ", value=" + value + ", userId=" + userId
                + ", referenceId=" + referenceId + ", expire=" + expire + ", version=" + version + ", status=" + status
                + ", createAt=" + createAt + ", updateAt=" + updateAt + "]";
    }

}