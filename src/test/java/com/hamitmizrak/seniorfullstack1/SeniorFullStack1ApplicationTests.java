package com.hamitmizrak.seniorfullstack1;

import com.hamitmizrak.seniorfullstack1.data.entity.BlogCategoryEntity;
import com.hamitmizrak.seniorfullstack1.data.repository.IBlogCategoryRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// IMPORT
import java.util.List;

// statik olatrak ekledim
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

// LOMBOK
@Log4j2

// TEST
/*@SpringBootTest
class SeniorFullStack1ApplicationTests {

}*/

// TEST
@SpringBootTest
// Test sıralaması için yazdım
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SeniorFullStack1ApplicationTests implements ITestCrudDatabase {

    // INJECTION
    private final IBlogCategoryRepository iBlogCategoryRepository;

    @Autowired
    public SeniorFullStack1ApplicationTests(IBlogCategoryRepository iBlogCategoryRepository) {
        this.iBlogCategoryRepository = iBlogCategoryRepository;
    }

    @BeforeAll
    static void getBeforeBlogCategoriesAllMethod() {
        System.out.println("Blog Categories Hepsinde önce gelen");
        log.info("Blog Categories önce gelen");
    }

    @BeforeEach
    void getBeforeEachBlogCategories() {
        System.out.println("Blog Categories Creatten hemen önce");
        log.info("Blog Categories Creatten hemen önce");
    }

    // CREATE
    @Override
    @Test
    @Order(1)
    public void testCreateDatabase() {
        System.out.println("Test Create  Blog Category");
        BlogCategoryEntity blogCategoryEntity = new BlogCategoryEntity();
        blogCategoryEntity.setCategoryName("test_blog_category");
        iBlogCategoryRepository.save(blogCategoryEntity);
        assertNotNull(iBlogCategoryRepository.findById(1L).get());
        // Eğer bulamazsa => java.util.NoSuchElementException: No value present
    }

    // FIND
    @Override
    @Test
    @Order(2)
    public void testFindDatabase() {
        System.out.println("Test Find Blog Category");
        BlogCategoryEntity blogCategoryEntity = iBlogCategoryRepository.findById(1L).get();
        assertEquals("computer", blogCategoryEntity.getCategoryName());
    }

    // LIST
    @Override
    @Test
    @Order(3)
    public void testListDatabase() {
        System.out.println("Test List Blog Category");
        Iterable<BlogCategoryEntity> blogCategoryEntityList = iBlogCategoryRepository.findAll();
        assertThat(blogCategoryEntityList).size().isGreaterThan(0);
    }

    // UPDATE
    @Override
    @Test
    @Order(4)
    public void testUpdateDatabase() {
        System.out.println("Test Update Blog Category");
        BlogCategoryEntity blogCategoryEntity = iBlogCategoryRepository.findById(1L).get();
        blogCategoryEntity.setCategoryName("değişti44");
        iBlogCategoryRepository.save(blogCategoryEntity);
        // Önceki ile şimdi eklediğim eşit olmamalı
        assertNotEquals("computer", iBlogCategoryRepository.findById(1L).get().getCategoryName());
    }

    // DELETE
    @Override
    @Test
    @Order(5)
    public void testDeleteDatabase() {
        System.out.println("Test Delete Blog Category");
        iBlogCategoryRepository.deleteById(1L);
        //assertThat(iBlogCategoryRepository.findById(1L).isPresent()).isFalse();
        assertThat(iBlogCategoryRepository.existsById(1L)).isFalse();
    }

    @Test
    public void getFail() {
        Assertions.fail("Bilerek hata gödnerdim");
    }

    @AfterEach
    void getAfterEachBlogCategories() {
        System.out.println("Blog Categories Creatten hemen sonra");
        log.info("Blog Categories Creatten hemen önce");
    }

    @Test
    @Disabled("disabled")
    public void getDisable() {
        Assertions.fail("Bilerek Testi kapattım");
    }

    @AfterAll
    static void getAfterBlogCategoriesAllMethod() {
        System.out.println("Blog Categories Hepsinde sonra gelen");
        log.info("Blog Categories önce gelen");
    }
}


