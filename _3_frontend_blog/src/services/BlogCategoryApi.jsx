import axios from "axios";


// PERSISTENCE DATA => Dikkat persist url'in başına Rootu yazmayı unutma (/)
const BLOG_CATEGORY_API_URL = "/blog/category/api/v1/";

class BlogCategoryApiImpl {
    // SPEED DATA
    // http://localhost:4444/blog/category/api/v1/speed/10
    // @GetMapping(value="/speed/{id}")
     categoryApiSpeedData(id) {
        return axios.get(`${BLOG_CATEGORY_API_URL}/speed/${id}`);
    }

    // ALL DELETE
    // http://localhost:4444/blog/category/api/v1/delete/all
    // @DeleteMapping(value="/delete/all")
     categoryApiAllDelete() {
        return axios.get(`${BLOG_CATEGORY_API_URL}/delete/all`);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    // CREATE
    // http://localhost:4444/blog/category/api/v1/create
    // @PostMapping("/create")
    categoryApiCreate(categoryDto) {
        return axios.post(`${BLOG_CATEGORY_API_URL}/create`,categoryDto);
    }

    // LIST
    // http://localhost:4444/blog/category/api/v1/list
    // @GetMapping(value="/list")
    categoryApiList() {
        return axios.get(`${BLOG_CATEGORY_API_URL}/list`);
    }

    // FIND
    // http://localhost:4444/blog/category/api/v1/find/1
    // @GetMapping(value="/find/{id}")
    categoryApiFindById(id) {
        return axios.get(`${BLOG_CATEGORY_API_URL}/find/${id}`);
    }

    // UPDATE
    // http://localhost:4444/blog/category/api/v1/update/1
    // @PutMapping(value="/update/{id}")
    categoryApiUpdate( id,categoryDto) {
        return axios.put(`${BLOG_CATEGORY_API_URL}/update/${id}`,categoryDto);
    }

    // DELETE BY ID
    // http://localhost:4444/blog/category/api/v1/delete/1
    // @DeleteMapping(value="/delete/{id}")
    categoryApiDeleteById( id) {
        return axios.delete(`${BLOG_CATEGORY_API_URL}/delete/${id}`);
    }

} //end class

// EXPORT DEFAULT(Bu classı dış dünyaya açmak için yazdık)
// NOT: en sondaki () parantezi boş olursa, class ismi ve default olarak export edilir.
export default new BlogCategoryApiImpl();
