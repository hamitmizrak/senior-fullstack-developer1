package com.hamitmizrak.seniorfullstack1.controller.api;

import org.springframework.http.ResponseEntity;

import java.util.List;

// D: Dto
public interface IBlogApi<D> {

    // SPEED DATA
    public ResponseEntity<String> blogApiSpeedData(Integer data);

    // DELETE ALL
    public ResponseEntity<String> blogApiDeleteAllData();

    ////////////////////////////////////////////////////////////
    // CRUD
    // CREATE
    public ResponseEntity<?> blogApiCreate(D d);

    // LIST
    public ResponseEntity<List<D>> blogApiList();

    // FIND
    public ResponseEntity<?> blogApiFindById(Long id);

    // UPDATE
    public ResponseEntity<?> blogApiUpdateById(Long id,D d);

    // DELETE
    public ResponseEntity<?> blogApiDeleteById(Long id);

} //end interface

