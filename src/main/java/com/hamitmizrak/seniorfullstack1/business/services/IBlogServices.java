package com.hamitmizrak.seniorfullstack1.business.services;

import java.util.List;

// D: Dto
// E: Entity
public interface IBlogServices<D,E> {

    // MODEL MAPPER
    public D entityToDto(E e);
    public E dtoToEntity(D d);

    /////////////////////////////////////////////////////////////
    // SPEED DATA
    public String blogServiceSpeedData(Integer data);

    // DELETE ALL
    public String blogServiceDeleteAllData();

    ////////////////////////////////////////////////////////////
    // CRUD
    // CREATE
    public D blogServiceCreate(D d);

    // LIST
    public List<D> blogServiceList();

    // FIND
    public D blogServiceFindById(Long id);

    // UPDATE
    public D blogServiceUpdateById(Long id,D d);

    // DELETE
    public D blogServiceDeleteById(Long id);

} //end interface
