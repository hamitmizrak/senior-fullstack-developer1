package com.hamitmizrak.seniorfullstack1.controller.api;

import org.springframework.http.ResponseEntity;

import java.util.List;

// D: Dto
public interface IBlogCategoriesApi<D> {

    // SPEED DATA
    public ResponseEntity<String>  blogCategoryApiSpeedData(Integer data);

    // DELETE ALL
    public ResponseEntity<String> blogCategoryApiDeleteAllData();

    ////////////////////////////////////////////////////////////
    // CRUD
    // CREATE
    public ResponseEntity<?> blogCategoryApiCreate(D d);

    // LIST
    public ResponseEntity<List<D>> blogCategoryApiList();

    // FIND
    public ResponseEntity<?> blogCategoryApiFindById(Long id);

    // UPDATE
    public ResponseEntity<?> blogCategoryApiUpdateById(Long id,D d);

    // DELETE
    public ResponseEntity<?> blogCategoryApiDeleteById(Long id);

} //end interface
