package com.hamitmizrak.seniorfullstack1.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder

// ENTITY
@Entity(name = "BlogCategories")
@Table(name="blogCategories")

// BlogCategoryDto(1)- BlogDto(N)
public class BlogCategoryEntity implements Serializable {

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
} // end BlogCategoryName
