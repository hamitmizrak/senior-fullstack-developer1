package com.hamitmizrak.seniorfullstack1.data.entity;

import com.hamitmizrak.seniorfullstack1.audit.AuditingAwareBaseEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data
@Log4j2
@Builder

// ENTITY
@Entity(name = "Blogs")
@Table(name="blog")
// BlogEntity(N) - BlogCategoryEntity(1)
public class BlogEntity extends AuditingAwareBaseEntity implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id",unique=true, nullable=false, updatable=false,insertable = true)
    private Long blogID;

    // DATE
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date systemCreatedDate;

    // Embedded
    @Embedded
    private EmbeddableBlogEntity embeddableBlogEntity=new EmbeddableBlogEntity();

    // RELATION
    // BlogEntity(N) - BlogCategoryEntity(1)
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="blog_category_id",nullable = false)
    private BlogCategoryEntity relationBlogCategoryEntity;

    // Constructor(Parametresiz)
    public BlogEntity() {
    }

    // Constructor(Parametreli)
    public BlogEntity(EmbeddableBlogEntity embeddableBlogEntity, BlogCategoryEntity relationBlogCategoryEntity) {
        this.embeddableBlogEntity = embeddableBlogEntity;
        this.relationBlogCategoryEntity = relationBlogCategoryEntity;
    }
} // end BlogCategoryName
