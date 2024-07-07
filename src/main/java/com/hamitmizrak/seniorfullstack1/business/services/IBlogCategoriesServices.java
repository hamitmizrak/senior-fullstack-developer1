package com.hamitmizrak.seniorfullstack1.business.services;

import java.util.List;

// D: Dto
// E: Entity
public interface IBlogCategoriesServices<D,E> {

    // MODEL MAPPER
    public D entityToDto(E e);
    public E dtoToEntity(D d);

    /////////////////////////////////////////////////////////////
    // SPEED DATA
    public String blogCategoryServiceSpeedData(Integer data);

    // DELETE ALL
    public String blogCategoryServiceDeleteAllData();

    ////////////////////////////////////////////////////////////
    // CRUD
    // CREATE
    public D blogCategoryServiceCreate(D d);

    // LIST
    public List<D> blogCategoryServiceList();

    // FIND
    public D blogCategoryServiceFindById(Long id);

    // UPDATE
    public D blogCategoryServiceUpdateById(Long id,D d);

    // DELETE
    public D blogCategoryServiceDeleteById(Long id);

} //end interface
