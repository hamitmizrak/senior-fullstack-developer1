package com.hamitmizrak.seniorfullstack1.controller.api.impl;

import com.hamitmizrak.seniorfullstack1.business.dto.BlogCategoryDto;
import com.hamitmizrak.seniorfullstack1.business.services.IBlogCategoriesServices;
import com.hamitmizrak.seniorfullstack1.controller.api.IBlogCategoriesApi;
import com.hamitmizrak.seniorfullstack1.error.ApiResult;
import com.hamitmizrak.seniorfullstack1.utils.frontend.ReactFrontend;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// LOMBOK
@RequiredArgsConstructor
@Log4j2

// API
@RestController
//@CrossOrigin
@CrossOrigin(origins = ReactFrontend.REACT_FRONTEND_PORT_URL) // http://localhost:3000
@RequestMapping("/blog/categories/api/v100")
public class BlogCategoriesApiImpl implements IBlogCategoriesApi<BlogCategoryDto> {

    // INJECTION
    private final IBlogCategoriesServices iBlogCategoriesServices;


    /////////////////////////////////////////////////////////////
    // SPEED DATA
    // http://localhost:4444/blog/categories/api/v100/speed
    // http://localhost:4444/blog/categories/api/v100/speed/0
    // http://localhost:4444/blog/categories/api/v100/speed/5
    @Override
    @GetMapping(value = {"/speed", "/speed/{id}"})
    public ResponseEntity<String> blogCategoryApiSpeedData(@PathVariable(name = "id", required = false) Integer data) {
        return ResponseEntity.ok(iBlogCategoriesServices.blogCategoryServiceSpeedData(data));
    }


    // DELETE ALL
    // http://localhost:4444/blog/categories/api/v100/delete/all
    @Override
    @DeleteMapping(value = "/delete/all")
    public ResponseEntity<String> blogCategoryApiDeleteAllData() {
        return ResponseEntity.ok(iBlogCategoriesServices.blogCategoryServiceDeleteAllData());
    }

    ////////////////////////////////////////////////////////////
    // CRUD
    // CREATE
    // http://localhost:4444/blog/categories/api/v100/create
    @Override
    @PostMapping("/create")
    public ResponseEntity<?> blogCategoryApiCreate(@Valid @RequestBody BlogCategoryDto blogCategoryDto) {
        return ResponseEntity.ok().body(iBlogCategoriesServices.blogCategoryServiceCreate(blogCategoryDto));
    }

    // LIST
    // http://localhost:4444/blog/categories/api/v100/list
    @Override
    @GetMapping("/list")
    public ResponseEntity<List<BlogCategoryDto>> blogCategoryApiList() {
        return ResponseEntity.status(HttpStatus.OK).body(iBlogCategoriesServices.blogCategoryServiceList());
    }

    // FIND
    // http://localhost:4444/blog/categories/api/v100/find
    // http://localhost:4444/blog/categories/api/v100/find/0
    // http://localhost:4444/blog/categories/api/v100/find/1
    @Override
    @GetMapping({"/find", "/find/{id}"})
    public ResponseEntity<?> blogCategoryApiFindById(@PathVariable(name = "id", required = false) Long id) {
        ApiResult apiResult;
        // id==null
        if (id == null) {
            log.error("not found");
            // Integer status, String error, String message, String path
            apiResult = new ApiResult(404, "null pointer", "not found", "http://localhost:4444/blog/categories/api/v1/find");
            return ResponseEntity.ok(apiResult);
        } else if (id == 0 || id < 0) {
            log.error("bad request");
            // Integer status, String error, String message, String path
            apiResult = new ApiResult(400, "bad request", "bad request", "http://localhost:4444/blog/categories/api/v1/find");
            return ResponseEntity.ok(apiResult);
        }
        return ResponseEntity.status(HttpStatus.OK).body(iBlogCategoriesServices.blogCategoryServiceFindById(id));
    }

    // UPDATE
    // http://localhost:4444/blog/categories/api/v100/update
    // http://localhost:4444/blog/categories/api/v100/update/0
    // http://localhost:4444/blog/categories/api/v100/update/1
    @Override
    @PutMapping({"/update", "/update/{id}"})
    public ResponseEntity<?> blogCategoryApiUpdateById(@PathVariable(name = "id", required = false) Long id, @Valid @RequestBody BlogCategoryDto blogCategoryDto) {
        return ResponseEntity.ok().body(iBlogCategoriesServices.blogCategoryServiceUpdateById(id, blogCategoryDto));
    }

    // DELETE
    // http://localhost:4444/blog/categories/api/v100/delete
    // http://localhost:4444/blog/categories/api/v100/delete/0
    // http://localhost:4444/blog/categories/api/v100/delete/1
    @Override
    @DeleteMapping({"/delete", "/delete/{id}"})
    public ResponseEntity<?> blogCategoryApiDeleteById(@PathVariable(name = "id", required = false) Long id) {
        return new ResponseEntity<>(iBlogCategoriesServices.blogCategoryServiceDeleteById(id), HttpStatus.OK);
    }

} // end BlogCategoriesApiImpl
