package org.forsrc.tcc.tcc.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "t_tcc_link")
//@JsonIgnoreProperties(value = { "tcc" })
@NamedEntityGraph(name = "neg_tcc_link", attributeNodes = @NamedAttributeNode(value = "tccInfoSet"))
public class TccLink implements java.io.Serializable {

    private static final long serialVersionUID = -3603568859174762821L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "tcc_id")
    // @JoinColumn(name = "tcc_id", referencedColumnName = "id")
    private Long tccId;

    @Column(name = "uri", length = 1000, nullable = false)
    private String uri;

    @Column(name = "reference_id", nullable = true)
    private Long referenceId;

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

    @Column(name = "expire", nullable = false, columnDefinition = "TIMESTAMP DEFAULT TIMESTAMPADD(MINUTE, 5, CURRENT_TIMESTAMP)")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date expire;

    @Column(name = "version", insertable = false, updatable = true, nullable = false, columnDefinition = "INT DEFAULT 0")
    @Version
    private int version;

    @Column(name = "status", length = 2, nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer status;

    @OneToMany(targetEntity = TccInfo.class, cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinColumn(name = "tcc_link_id", referencedColumnName = "id")
    //@JoinTable(name = "t_tcc_info", joinColumns = @JoinColumn(name = "tcc_link_id"), inverseJoinColumns = @JoinColumn(name = "id"))
    private Set<TccInfo> tccInfoSet = new HashSet<>();

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

    public Set<TccInfo> getTccInfoSet() {
        return tccInfoSet;
    }

    public void setTccInfoSet(Set<TccInfo> tccInfoSet) {
        this.tccInfoSet = tccInfoSet;
    }

    @Override
    public String toString() {
        return "TccLink [id=" + id + ", tccId=" + tccId + ", uri=" + uri + ", referenceId=" + referenceId
                + ", createAt=" + createAt + ", updateAt=" + updateAt + ", expire=" + expire + ", version=" + version
                + ", status=" + status + ", tccInfoList=" + tccInfoSet + "]";
    }

}