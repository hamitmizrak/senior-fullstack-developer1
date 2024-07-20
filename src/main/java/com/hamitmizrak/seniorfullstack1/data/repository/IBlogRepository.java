package com.hamitmizrak.seniorfullstack1.data.repository;


import com.hamitmizrak.seniorfullstack1.data.entity.BlogEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// CrudRepository<RegisterEntity,Long>
// JpaRepository<RegisterEntity,Long>
// PagingAndSortingRepository<RegisterEntity,Long>
@Repository
public interface IBlogRepository extends CrudRepository<BlogEntity,Long> {
}
