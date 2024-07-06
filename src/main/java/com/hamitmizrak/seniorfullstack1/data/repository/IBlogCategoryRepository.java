package com.hamitmizrak.seniorfullstack1.data.repository;

import com.hamitmizrak.seniorfullstack1.data.entity.BlogCategoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
// CrudRepository<BlogCategoryEntity,Long>
// JpaRepository<BlogCategoryEntity,Long>
// PagingAndSortingRepository<BlogCategoryEntity,Long>

@Repository
public interface IBlogCategoryRepository extends CrudRepository<BlogCategoryEntity,Long> {
    // Delivered Query (Kendi Sorgularımızı yazarız)
    Optional<BlogCategoryEntity> findByCategoryName(String categoryName);
}
