package com.hamitmizrak.seniorfullstack1.blogcategory;

import com.hamitmizrak.seniorfullstack1.data.entity.BlogCategoryEntity;
import com.hamitmizrak.seniorfullstack1.data.repository.IBlogCategoryRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// statik olarak eklemem
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

// LOMBOK
@Log4j2

/*
Spring boot, @SpringBootTest uygulamalarında kapsamlı testler yazmak için kullanılır
Spring boot uygulama,@SpringBootTest bağlamını(application Context) başlatır.
Bu sayede @Service @Repository @Controller bu annotationlara sahip sınıflara test sırasında erişim sağlayabilirim
*/
// Test Sırasını Belirleme
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class BlogCategoryServicesImplTest implements IBlogCategoryTest {

    // Test Metot Yapısında
    // 1-Hazırlık(Setup): Testin çalışması için başlangıç koşullarını hazırlar
    // 2-Eylem(Action): Test edilmek istenen işlevleri çalıştırır.
    // 3-Doğrulama(Assertion): Test Sonuçlarını doğrular
    // 4-Temizlik (Teardown):  Testten sonra gerekli temizlik işlemlerini yapar.

    /*
     ### Zengin Assert Metotları
    JUnit, test sonuçlarını doğrulamak için çeşitli assert metotları sağlar.
    Bu metotlar, beklenen ve gerçek sonuçları karşılaştırarak testlerin başarılı olup olmadığını belirler.
    expected:Beklenen
    actual: Gerçek (Benim yazdığım sonuç)
    assertEquals(expected, actual):** İki değerin eşit olup olmadığını kontrol eder.
    assertTrue(condition):** Koşulun doğru olup olmadığını kontrol eder.
    assertFalse(condition):** Koşulun yanlış olup olmadığını kontrol eder.
    assertNull(object):** Nesnenin null olup olmadığını kontrol eder.
    assertNotNull(object):** Nesnenin null olmadığını kontrol eder.
    assertArrayEquals(expectedArray, actualArray):** İki dizinin eşit olup olmadığını kontrol eder.
  */

    // 1-Hazırlık(Setup):
    // Variable
    private BlogCategoryEntity blogCategoryEntity;

    // INJECTION
    private final IBlogCategoryRepository iBlogCategoryRepository;
    @Autowired
    public BlogCategoryServicesImplTest(IBlogCategoryRepository iBlogCategoryRepository) {
        this.iBlogCategoryRepository = iBlogCategoryRepository;
    }

    // Hepsinden Önce (All= static)
    @BeforeAll
    static void getBeforeAllBlogCategoriesAllMethod() {
        System.out.println("******Blog Categories Methodlarından hepsinden Önce********");
        log.info("******Blog Categories Methodlarından hepsinden Önce********");
    }

    // Metottan Hemen Önce
    @BeforeEach
    void getBeforeEachBlogCategoriesAllMethod() {
        System.out.println("Blog Categories Methodlarından Hemen Önce");
        log.info("Blog Categories Methodlarından hepsinden Önce");
        // blogCategoryEntity => instance
        // Her metottan hemen önce Objeyi instance yap
        blogCategoryEntity = new BlogCategoryEntity();
    }

    // Metottan Hemen Sonra ( 4-Temizlik (Teardown): )
    @AfterEach
    void getAfterEachBlogCategoriesAllMethod() {
        System.out.println("Blog Categories Methodlarından Hemen Sonra");
        log.info("Blog Categories Methodlarından hepsinden Sonra");
        // Her metottan hemen sonra Objeyi null yap
        blogCategoryEntity = null;
    }


    // Hepsinden Sonra
    @AfterAll  //(All= static)
    static void getAfterAllBlogCategoriesAllMethod() {
        System.out.println("******Blog Categories Methodlarından hepsinden Sonra**********");
        log.info("******Blog Categories Methodlarından hepsinden Sonra**********");
    }

    // getFail
    @Test
    @Override
    public void getFail(){
        //Assertions.fail("İsteyerek Hata Gönderdim");
    }

    @Test
    @Disabled("disabled")
    @Override
    public void getDisable() {
        Assertions.fail("Bilerek Bu Testi Kapattım");
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////
    // BLOG CATEGORY CREATE
    //@Test
    @RepeatedTest(1) // Bu Create testini 3 defa çalıştır
    @Order(1)
    @Tag("create") // Testleri mantıksal gruplar ayırmak için
    @Override
    public void blogCategoryCreateTest() {
        System.out.println("Blog Categories Create");
        blogCategoryEntity.setCategoryName("bilgisayar");
        iBlogCategoryRepository.save(blogCategoryEntity);
        assertNotNull(iBlogCategoryRepository.findById(1L).get()); // kaydedilmesi
    }

    // BLOG CATEGORY FIND
    @Test
    @Order(2)
    @Tag("find") // Testleri mantıksal gruplar ayırmak için
    @Override
    public void blogCategoryFindTest() {
        System.out.println("Blog Categories Find");
        // Bulma
        blogCategoryEntity=iBlogCategoryRepository.findById(1L).get();
        assertEquals("bilgisayar",blogCategoryEntity.getCategoryName());
    }

    // BLOG CATEGORY LIST
    @Test
    @Order(3)
    @Tag("list") // Testleri mantıksal gruplar ayırmak için
    @Override
    public void blogCategoryListTest() {
      System.out.println("Blog Categories List");
      Iterable<BlogCategoryEntity> list=iBlogCategoryRepository.findAll();
      assertThat(list).size().isGreaterThan(0);
    }

    // BLOG CATEGORY UPDATE
    @Test
    @Order(4)
    @Tag("update") // Testleri mantıksal gruplar ayırmak için
    @Override
    public void blogCategoryUpdateTest() {
        System.out.println("Blog Categories Update");
        blogCategoryEntity=iBlogCategoryRepository.findById(1L).get();
        blogCategoryEntity.setCategoryName("laptop");
        iBlogCategoryRepository.save(blogCategoryEntity);
        // Önceki bilgisayar ile şimdiki laptop
        assertNotEquals("bilgisayar",iBlogCategoryRepository.findById(1L).get().getCategoryName());
    }

    // BLOG CATEGORY DELETE
    @Test
    @Order(5)
    @Tag("delete") // Testleri mantıksal gruplar ayırmak için
    @Override
    public void blogCategoryDeleteTest() {
        System.out.println("Blog Categories Delete");
        iBlogCategoryRepository.deleteById(1L);
        assertThat(iBlogCategoryRepository.existsById(1L)).isFalse();
    }

} //end class test
