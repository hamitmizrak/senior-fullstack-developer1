package com.hamitmizrak.seniorfullstack1.business.services.impl;

import com.hamitmizrak.seniorfullstack1.bean.ModelMapperBean;
import com.hamitmizrak.seniorfullstack1.business.dto.BlogCategoryDto;
import com.hamitmizrak.seniorfullstack1.business.dto.BlogDto;
import com.hamitmizrak.seniorfullstack1.business.services.IBlogServices;
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
import java.util.UUID;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// SERVICES
@Service
public class BlogServicesImpl implements IBlogServices<BlogDto, BlogEntity> {

    // INJECTION
    private final IBlogRepository iBlogRepository;
    private final ModelMapperBean modelMapperBean;

    // MODEL MAPPER
    @Override
    public BlogDto entityToDto(BlogEntity blogEntity) {
        return modelMapperBean.getModelMapperMethod().map(blogEntity,BlogDto.class);
    }

    @Override
    public BlogEntity dtoToEntity(BlogDto blogDto) {
        return modelMapperBean.getModelMapperMethod().map(blogDto,BlogEntity.class);
    }

    /////////////////////////////////////////////////////////////
    // SPEED DATA
    @Override
    @Transactional
    public String blogServiceSpeedData(Integer data) {
        if(data!=null){
            for (int i = 0; i <=data ; i++) {
                BlogEntity blogEntity=new BlogEntity();
                //blogEntity.set("Category "+ UUID.randomUUID().toString());
                iBlogRepository.save(blogEntity);
            }
        }else {
            throw new HamitMizrakException("Speed Data oluşturulmadı");
        }
        return data+" tane veri eklendi";
    }

    // DELETE ALL
    @Override
    public String blogServiceDeleteAllData() {
        iBlogRepository.deleteAll();
        return blogServiceList().size()+" tane veri silindi";
    }

    ////////////////////////////////////////////////////////////
    // CRUD
    // @Transaction (Create,Delete,Update)

    // CREATE
    @Override
    @Transactional
    public BlogDto blogServiceCreate(BlogDto blogDto) {
        if(blogDto!=null){
            BlogEntity blogCategoryEntity=dtoToEntity(blogDto);
            iBlogRepository.save(blogCategoryEntity);
            blogDto.setHeader(blogCategoryEntity.getEmbeddableBlogEntity().getHeader());
            blogDto.setTitle(blogCategoryEntity.getEmbeddableBlogEntity().getTitle());
            blogDto.setContent(blogCategoryEntity.getEmbeddableBlogEntity().getContent());
            blogDto.setImage(blogCategoryEntity.getEmbeddableBlogEntity().getImage());
            return blogDto;
        }else{
            throw new NullPointerException(BlogCategoryDto.class+" boş ");
        }
    }

    // LIST
    @Override
    public List<BlogDto> blogServiceList() {
        Iterable<BlogEntity> categoryEntityIterable= iBlogRepository.findAll();
        List<BlogDto> blogDtoArrayList=new ArrayList<>();
        for (BlogEntity entity: categoryEntityIterable){
            BlogDto blogDto=entityToDto(entity);
            blogDtoArrayList.add(blogDto);
        }
        log.info(" Category Name Listesi: "+blogDtoArrayList.size());
        //return List.of();
        return blogDtoArrayList;
    }

    // FIND
    @Override
    public BlogDto blogServiceFindById(Long id) {
        BlogEntity findBlogEntity=null;
        if(id!=null){
            findBlogEntity= iBlogRepository.findById(id)
                    .orElseThrow(()->new NotFound404Exception(id+" nolu veri yoktur"));
        }else if(id==null){
            throw new NullPointerException("blog category id null");
        }
        return entityToDto(findBlogEntity);
    }

    // UPDATE
    @Transactional
    @Override
    public BlogDto blogServiceUpdateById(Long id, BlogDto blogDto) {
        BlogDto findBlogDto=blogServiceFindById(id);
        if(findBlogDto!=null){
            BlogEntity blogEntity=dtoToEntity(blogDto);
            blogEntity.getEmbeddableBlogEntity().setHeader(blogDto.getHeader());
            blogEntity.getEmbeddableBlogEntity().setContent(blogDto.getContent());
            blogEntity.getEmbeddableBlogEntity().setTitle(blogDto.getTitle());
            blogEntity.getEmbeddableBlogEntity().setImage(blogDto.getImage());
            iBlogRepository.save(blogEntity);
            return findBlogDto;
        }
        return null;
    }

    // DELETE
    @Transactional
    @Override
    public BlogDto blogServiceDeleteById(Long id) {
        BlogDto findBlogCategoryDto=blogServiceFindById(id);
        if(findBlogCategoryDto!=null){
            iBlogRepository.deleteById(id);
            return findBlogCategoryDto;
        }
        return null;
    }
}