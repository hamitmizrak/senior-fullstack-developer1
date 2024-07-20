package com.hamitmizrak.seniorfullstack1.business.services;


import com.hamitmizrak.seniorfullstack1.bean.ModelMapperBean;
import com.hamitmizrak.seniorfullstack1.business.dto.BlogDto;
import com.hamitmizrak.seniorfullstack1.business.services.impl.IBlogServices;
import com.hamitmizrak.seniorfullstack1.data.entity.BlogEntity;
import com.hamitmizrak.seniorfullstack1.data.repository.IBlogRepository;
import com.hamitmizrak.seniorfullstack1.exception.HamitMizrakException;
import com.hamitmizrak.seniorfullstack1.exception.NotFound404Exception;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// SERVICES
@Service
public class BlogServicesImpl implements IBlogServices<BlogDto, BlogEntity> {

    // INJECTION (Lombok Constructor Field) => 3.YOL
    private final IBlogRepository iBlogRepository;
    private final ModelMapperBean modelMapperBeanClass;

    //////////////////////////////////////////////////////////////////////////////
    // SPEED DATA
    @Override
    public String blogSpeedData(Long data) {
        return null;
    }

    // DELETE ALL
    @Override
    public String blogAllDelete() {
        iBlogRepository.deleteAll();
        return null;
    }

    //////////////////////////////////////////////////////////////////////////////
    // MODEL MAPPER
    @Override
    public BlogDto entityToDto(BlogEntity blogEntity) {
        return modelMapperBeanClass.getModelMapperMethod().map(blogEntity,BlogDto.class);
    }

    @Override
    public BlogEntity dtoToEntity(BlogDto blogDto) {
        return  modelMapperBeanClass.getModelMapperMethod().map(blogDto,BlogEntity.class);
    }

    //////////////////////////////////////////////////////////////////////////////
    // CREATE
    @Override
    @Transactional // create, delete, update
    public BlogDto  blogServiceCreate(BlogDto blogDto) {
        if(blogDto!=null){
            BlogEntity blogEntity=dtoToEntity(blogDto);
            iBlogRepository.save(blogEntity);
            blogDto.setBlogId(blogEntity.getBlogId());
            blogDto.setSystemCreatedDate(blogEntity.getSystemCreatedDate());
        }else{
            throw  new NullPointerException("blogdto null veri");
        }
        return blogDto;
    }

    // LIST
    @Override
    public List<BlogDto>  blogServiceList() {
        Iterable<BlogEntity> entityIterable=  iBlogRepository.findAll();
        // Dto To entityb List
        List<BlogDto> categoryDtoList=new ArrayList<>();
        for (BlogEntity entity:  entityIterable) {
            BlogDto blogDto=entityToDto(entity);
            categoryDtoList.add(blogDto);
        }
        log.info("Liste Sayısı: "+categoryDtoList.size());
        return categoryDtoList;
    }

    // FIND
    @Override
    public BlogDto  blogServiceFindById(Long id) {
        // 1.YOL (FIND)
        /*
        Optional<BlogEntity> findOptionalBlogEntity=  iCategoryRepository.findById(id);
        CategoryDto categoryDto=entityToDto(findOptionalBlogEntity.get());
        if(findOptionalBlogEntity.isPresent()){
            return categoryDto;
        }
        */

        // 2.YOL (FIND)
        BlogEntity findBlogEntity=  null;
        if(id!=null){
            findBlogEntity=  iBlogRepository.findById(id)
                    .orElseThrow(()->new NotFound404Exception(id+" nolu id yoktur"));
        }else if(id==null) {
            throw new HamitMizrakException("İd null olarak geldi");
        }
        return entityToDto(findBlogEntity);
    }

    // UPDATE
    @Override
    @Transactional // create, delete, update
    public BlogDto  blogServiceUpdate(Long id, BlogDto blogDto) {
        // Önce Bul
        BlogDto blogFindDto= blogServiceFindById(id);
       if(blogFindDto!=null){
           BlogEntity blogEntity=dtoToEntity(blogFindDto);
           blogEntity.getBlogEntityEmbeddable().setTitle(blogDto.getTitle());
           blogEntity.getBlogEntityEmbeddable().setHeader(blogDto.getHeader());
           blogEntity.getBlogEntityEmbeddable().setContent(blogDto.getContent());
           iBlogRepository.save(blogEntity);
           // Dönüştede ID ve Date Set et
       }
        return blogDto;
    }

    // DELETE
    @Override
    @Transactional // create, delete, update
    public BlogDto blogServiceDeleteById(Long id) {
        // Önce Bul
        BlogDto categoryFindDto= blogServiceFindById(id);
        if(categoryFindDto!=null){
            iBlogRepository.deleteById(id);
            // Dönüştede ID ve Date Set et
        }
        return categoryFindDto;
    }

} //end class
