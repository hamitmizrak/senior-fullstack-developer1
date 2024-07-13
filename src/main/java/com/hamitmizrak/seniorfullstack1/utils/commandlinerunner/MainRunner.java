package com.hamitmizrak.seniorfullstack1.utils.commandlinerunner;

import com.hamitmizrak.seniorfullstack1.controller.api.IBlogCategoriesApi;
import com.hamitmizrak.seniorfullstack1.data.entity.BlogCategoryEntity;
import com.hamitmizrak.seniorfullstack1.data.repository.IBlogCategoryRepository;
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
          BlogCategoryEntity blogCategoryEntity1=BlogCategoryEntity.builder().categoryName("computer").build();
          iBlogCategoryRepository.save(blogCategoryEntity1);

          BlogCategoryEntity blogCategoryEntity2=BlogCategoryEntity.builder().categoryName("laptop").build();
          iBlogCategoryRepository.save(blogCategoryEntity2);

          BlogCategoryEntity blogCategoryEntity3=BlogCategoryEntity.builder().categoryName("pc").build();
          iBlogCategoryRepository.save(blogCategoryEntity3);
      };
    }
    // START
    public void end(){
        log.info("###END#######");
    }
}
