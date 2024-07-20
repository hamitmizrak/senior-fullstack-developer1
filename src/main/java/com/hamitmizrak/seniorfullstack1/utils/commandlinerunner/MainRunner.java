package com.hamitmizrak.seniorfullstack1.utils.commandlinerunner;

import com.hamitmizrak.seniorfullstack1.controller.api.IBlogCategoriesApi;
import com.hamitmizrak.seniorfullstack1.data.entity.BlogCategoryEntity;
import com.hamitmizrak.seniorfullstack1.data.entity.BlogEntity;
import com.hamitmizrak.seniorfullstack1.data.repository.IBlogCategoryRepository;
import com.hamitmizrak.seniorfullstack1.data.repository.IBlogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// LOMBOK
@RequiredArgsConstructor

// Command Line runner
@Configuration
@Log4j2
public class MainRunner {

    // INJECTION
    private final IBlogCategoryRepository iBlogCategoryRepository;
    private final IBlogRepository iBlogRepository;

    // START
    public void start(){
        log.info("###START#######");
    }
    // Command Line Runner
    @Bean
    public CommandLineRunner blog(){
     // Lambda Expression
      return args -> {
        log.info("Blog Categories");
          System.out.println("Blog Categories");

          // BlogCategory(1) - Blog(N)
          // Tekil Kategori'dir
          BlogCategoryEntity javaBlogCategory= new BlogCategoryEntity();
          javaBlogCategory.setCategoryName("java");
          iBlogCategoryRepository.save(javaBlogCategory);

          BlogCategoryEntity frontBlogCategory= BlogCategoryEntity
                  .builder().categoryName("frontend").build();
          iBlogCategoryRepository.save(frontBlogCategory);


          // Çoğul Blog'tur
          // Java
          /*
          BlogEntity blogEntity1= new BlogEntity();
          blogEntity1.getEmbeddableBlogEntity().setHeader("Javanın Gelecekteki Kullanımı");
          blogEntity1.getEmbeddableBlogEntity().setTitle("Javanın Gelecekteki Kullanımı devamı ....");
          blogEntity1.getEmbeddableBlogEntity().setContent("Java yüksek seviyeli bir dildir.");
          blogEntity1.getEmbeddableBlogEntity().setImage("java.jpg");
          blogEntity1.setRelationBlogCategoryEntity(javaBlogCategory);
          iBlogRepository.save(blogEntity1);*/

          /*
          BlogEntity blogEntity2= new BlogEntity();
          blogEntity2.getEmbeddableBlogEntity().setHeader("JSP Gelecekteki Kullanımı");
          blogEntity2.getEmbeddableBlogEntity().setTitle("JSP Gelecekteki Kullanımı devamı ....");
          blogEntity2.getEmbeddableBlogEntity().setContent("JSP bir java kütüphanesidir.");
          blogEntity2.getEmbeddableBlogEntity().setImage("jsp.jpg");
          blogEntity2.setRelationBlogCategoryEntity(javaBlogCategory);
          iBlogRepository.save(blogEntity2);

          // Frontend
          BlogEntity blogEntity3= new BlogEntity();
          blogEntity3.getEmbeddableBlogEntity().setHeader("React JS Gelecekteki Kullanımı");
          blogEntity3.getEmbeddableBlogEntity().setTitle("React JS Gelecekteki Kullanımı devamı ....");
          blogEntity3.getEmbeddableBlogEntity().setContent("React bir Javascript kütüphanesidir.");
          blogEntity3.getEmbeddableBlogEntity().setImage("react.jpg");
          blogEntity3.setRelationBlogCategoryEntity(frontBlogCategory);
          iBlogRepository.save(blogEntity3);
          */

      };
    }
    // START
    public void end(){
        log.info("###END#######");
    }
}
