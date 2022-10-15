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
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "t_tcc")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@NamedEntityGraph(
        name = "neg_tcc", 
        attributeNodes = @NamedAttributeNode(value = "tccLinkSet", subgraph = "subgraph.tccLinkSet"), 
        subgraphs = {
            @NamedSubgraph(name = "subgraph.tccLinkSet", 
                           attributeNodes = @NamedAttributeNode(value = "tccInfoSet", subgraph = "subgraph.tccInfoSet"))})
public class Tcc implements java.io.Serializable {

    private static final long serialVersionUID = 4706144731706609711L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "expire", nullable = false, columnDefinition = "TIMESTAMP DEFAULT TIMESTAMPADD(MINUTE, 5, CURRENT_TIMESTAMP)")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date expire;

    @Column(name = "status", length = 2, nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer status;

    @Column(name = "times", length = 2, nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer times;

    @Column(name = "microservice", length = 200, nullable = false, columnDefinition = "VARCHAR(200) DEFAULT ''")
    private String microservice;

    @Column(name = "version", insertable = false, updatable = true, nullable = false, columnDefinition = "INT DEFAULT 0")
    @Version
    private int version;

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

    @OneToMany(targetEntity = TccLink.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "tcc_id", referencedColumnName = "id")
    private Set<TccLink> tccLinkSet = new HashSet<>();

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

    public Set<TccLink> getTccLinkSet() {
        return tccLinkSet;
    }

    public void setTccLinkSet(Set<TccLink> tccLinkSet) {
        this.tccLinkSet = tccLinkSet;
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
        return "Tcc [id=" + id + ", expire=" + expire + ", status=" + status + ", times=" + times + ", microservice="
                + microservice + ", version=" + version + ", createAt=" + createAt + ", updateAt=" + updateAt
                + ", tccLinkSet=" + tccLinkSet + "]";
    }

}