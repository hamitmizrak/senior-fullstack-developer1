package com.hamitmizrak.seniorfullstack1.data.entity;

import com.hamitmizrak.seniorfullstack1.audit.AuditingAwareBaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

// LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder

// ENTITY
@Entity(name = "BlogCategories")
@Table(name="blogCategory")
// BlogCategoryDto(1)- BlogDto(N)
public class BlogCategoryEntity extends AuditingAwareBaseEntity implements Serializable {

    // Serileştirme
    public static final Long serialVersionUID=1L;

    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id",unique=true, nullable=false, updatable=false,insertable = true)
    private Long categoryID;

    // DATE
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date systemCreatedDate;

    // Category Name
    @Column(name = "category_name")
    private String categoryName;

    // Constructor(Parametreli)
    public BlogCategoryEntity(String categoryName) {
        this.categoryName = categoryName;
    }

    // Constructor(Parametreli)
    public BlogCategoryEntity(String categoryName,List<BlogEntity> relationBlogEntityList) {
        this.relationBlogEntityList = relationBlogEntityList;
        this.categoryName = categoryName;
    }

    // RELATION
    // BlogCategoryDto(1)- BlogDto(N)
    @OneToMany(mappedBy = "relationCategoryEntity",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    List<BlogEntity> relationBlogEntityList;


} // end BlogCategoryName
