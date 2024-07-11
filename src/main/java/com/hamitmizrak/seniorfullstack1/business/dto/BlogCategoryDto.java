package com.hamitmizrak.seniorfullstack1.business.dto;

import com.hamitmizrak.seniorfullstack1.annotation.AUniqueBlogCategoryName;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;
import java.util.Date;

// LOMBOK
@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
@Builder

// BlogCategoryDto(1)- BlogDto(N)
public class BlogCategoryDto implements Serializable {

    // Serileştirme
   public static final Long serialVersionUID=1L;

   // ID
    private Long categoryID;

    // DATE
    @Builder.Default
    private Date systemCreatedDate=new Date(System.currentTimeMillis());

    // Category Name
    //@AUniqueBlogCategoryName
    @NotEmpty(message = "{blog.category.validation.constraints.NotNull.message}")
    @Size(min = 2, message = "{blog.category.least.validation.constraints.NotNull.message}")
    private String categoryName;
} //end BlogCategoryDto
