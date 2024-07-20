package com.hamitmizrak.seniorfullstack1.utils.commandlinerunner;


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
    private final IBlogRepository iBlogRepository ;

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

          // Tekil Kategory
          BlogCategoryEntity computerCategory=new BlogCategoryEntity();
          computerCategory.setCategoryName("Bilgisayar");
          iBlogCategoryRepository.save(computerCategory);

          // Tekil Kategory
          BlogCategoryEntity tabletCategory=new BlogCategoryEntity();
          tabletCategory.setCategoryName("Tablet");
          iBlogCategoryRepository.save(tabletCategory);

          // Blog-1
          BlogEntity blogEntity=new BlogEntity();
          blogEntity.getBlogEntityEmbeddable().setHeader("Header-1");
          blogEntity.getBlogEntityEmbeddable().setContent("Content-1");
          blogEntity.getBlogEntityEmbeddable().setTitle("Title-1");
          blogEntity.setRelationCategoryEntity(computerCategory);
          iBlogRepository.save(blogEntity);

          // Blog-2
          BlogEntity blogEntity2=new BlogEntity();
          blogEntity2.getBlogEntityEmbeddable().setHeader("Header-2");
          blogEntity2.getBlogEntityEmbeddable().setContent("Content-2");
          blogEntity2.getBlogEntityEmbeddable().setTitle("Title-2");
          blogEntity2.setRelationCategoryEntity(computerCategory);
          iBlogRepository.save(blogEntity2);

          // Blog-3
          BlogEntity blogEntity3=new BlogEntity();
          blogEntity3.getBlogEntityEmbeddable().setHeader("Header-3");
          blogEntity3.getBlogEntityEmbeddable().setContent("Content-3");
          blogEntity3.getBlogEntityEmbeddable().setTitle("Title-3");
          blogEntity3.setRelationCategoryEntity(tabletCategory);
          iBlogRepository.save(blogEntity3);


      };
    }
    // START
    public void end(){
        log.info("###END#######");
    }
}
