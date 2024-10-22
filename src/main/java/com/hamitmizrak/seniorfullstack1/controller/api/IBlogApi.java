package com.hamitmizrak.seniorfullstack1.controller.api;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBlogApi<D> {

    // ALL DELETE
    public ResponseEntity<String> blogApiAllDelete();

    // SPEED DATA
    public ResponseEntity<List<D>> blogApiSpeedData(Long key);

    ////////////////////////////////////////////////////////////////////////////

    // C R U D
    // CREATE
    public ResponseEntity<?>  blogApiCreate(D d);

    // LIST
    public ResponseEntity<List<D>>  blogApiList();

    // FIND BY
    public ResponseEntity<?>  blogApiFindById(Long id);

    // UPDATE
    public ResponseEntity<?>  blogApiUpdate(Long id,D d);

    // DELETE
    public ResponseEntity<?>  blogApiDeleteById(Long id);

}
