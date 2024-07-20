package com.hamitmizrak.seniorfullstack1.controller.api.impl;

import com.hamitmizrak.seniorfullstack1.business.dto.BlogDto;
import com.hamitmizrak.seniorfullstack1.business.services.IBlogServices;
import com.hamitmizrak.seniorfullstack1.controller.api.IBlogApi;
import com.hamitmizrak.seniorfullstack1.utils.frontend.ReactFrontend;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// API
@RestController
@CrossOrigin(origins = ReactFrontend.REACT_FRONTEND_PORT_URL) // http://localhost:3000
@RequestMapping("/blog/api/v100")
public class BlogApiImpl implements IBlogApi<BlogDto> {

    // INJECTION
    private final IBlogServices iBlogServices;

    // SPEED DATA
    // http://localhost:4444/blog/api/v100/speed/data
    @Override
    @GetMapping(value="/speed/{data}")
    public ResponseEntity<String> blogApiSpeedData(@PathVariable(name="data") Integer data) {
        return ResponseEntity.ok(iBlogServices.blogServiceSpeedData(data));
    }

    // ALL DELETE
    // http://localhost:4444/blog/api/v100/delete/all
    @Override
    @GetMapping(value="/delete/all")
    public ResponseEntity<String> blogApiDeleteAllData() {
        return ResponseEntity.ok(iBlogServices.blogServiceDeleteAllData());
    }

    //////////////////////////////////////////////////////////////
    // CRUD

    // CREATE
    // http://localhost:4444/blog/api/v100/create
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> blogApiCreate(@Valid @RequestBody BlogDto blogDto) {
        return ResponseEntity.ok(iBlogServices.blogServiceCreate(blogDto));
    }

    // LIST
    // http://localhost:4444/blog/api/v100/list
    @Override
    @GetMapping("/list")
    public ResponseEntity<List<BlogDto>> blogApiList() {
        return ResponseEntity.ok(iBlogServices.blogServiceList());
    }

    // FIND
    // http://localhost:4444/blog/api/v100/find/1
    @Override
    @GetMapping("/find/{id}")
    public ResponseEntity<?> blogApiFindById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(iBlogServices.blogServiceFindById(id));
    }

    // UPDATE
    // http://localhost:4444/blog/api/v100/update/1
    @Override
    @PutMapping("/update/{id}")
    public ResponseEntity<?> blogApiUpdateById(@PathVariable(name = "id") Long id, @Valid @RequestBody  BlogDto blogDto) {
        return ResponseEntity.ok(iBlogServices.blogServiceUpdateById(id,blogDto));
    }

    // DELETE
    // http://localhost:4444/blog/api/v100/delete/1
    @Override
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> blogApiDeleteById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(iBlogServices.blogServiceDeleteById(id));
    }

} // end Api Blog
