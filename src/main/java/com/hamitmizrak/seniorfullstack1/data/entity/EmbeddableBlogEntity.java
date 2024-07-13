package com.hamitmizrak.seniorfullstack1.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// LOMBOK
@Getter
@Setter

@Embeddable
public class EmbeddableBlogEntity {

    // HEADER
   @Column(
           name = "header",
           nullable = false,
           unique = true,
           length = 600,
           insertable = true,
           updatable = true,
           columnDefinition = "varchar(255) default 'Blog Başlığını Yazmadınız ..."
   )
    private String header;

    // CONTENT
    @Lob
    @Column(name="content",columnDefinition = "varchar(255) default 'Blog İçeriğini Eklemediniz'")
    private String content;

    // TITLE
    private String title;

    // IMAGE
    private String image;

    /*
    @Transient // Sadece Javada olsun ancak Database(Entity) eklenmesin.
    private Object justJava;
    */
}
