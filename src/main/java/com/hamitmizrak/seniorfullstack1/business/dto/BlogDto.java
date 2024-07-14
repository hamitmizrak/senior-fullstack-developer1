package com.hamitmizrak.seniorfullstack1.business.dto;

import com.hamitmizrak.seniorfullstack1.audit.AuditingAwareBaseDto;
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

// BlogDto(N) - BlogCategoryDto(1)
public class BlogDto extends AuditingAwareBaseDto implements Serializable {

    // Serileştirme
   public static final Long serialVersionUID=1L;

   // ID
    private Long blogID;

    // DATE
    @Builder.Default
    private Date systemCreatedDate=new Date(System.currentTimeMillis());

    // HEADER
    @NotEmpty(message = "{blog.header.validation.constraints.NotNull.message}")
    @Size(min = 2, message = "{blog.header.least.validation.constraints.NotNull.message}")
    private String header;

    // TITLE
    @NotEmpty(message = "{blog.title.validation.constraints.NotNull.message}")
    @Size(min = 2, message = "{blog.title.least.validation.constraints.NotNull.message}")
    private String title;

    // CONTENT
    @NotEmpty(message = "{blog.content.validation.constraints.NotNull.message}")
    @Size(min = 2, message = "{blog.content.least.validation.constraints.NotNull.message}")
    private String content;

    // IMAGE
    private String image;

} //end BlogCategoryDto
