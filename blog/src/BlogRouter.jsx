// rfce

// REACT
import React from "react";
import { withTranslation } from "react-i18next";
import { Navigate, Route, Routes } from "react-router-dom";
import BlogCategoryCreate from "./components/blogCategory/BlogCategoryCreate";
import BlogCategoryList from "./components/blogCategory/BlogCategoryList";
import BlogCategoryUpdate from "./components/blogCategory/BlogCategoryUpdate";
import BlogCategoryView from "./components/blogCategory/BlogCategoryView";

// HEADER,MAIN,FOOTER
import BlogFooter from "./components/BlogFooter";
import BlogHeader from "./components/BlogHeader";
import BlogMain from "./components/BlogMain";
import NotFound from "./components/NotFound";

// FUNCTION COMPONENT
function BlogRouter() {
  return (
    // <div>BlogRouter</div>
    // <>BlogRouter</>
    <React.Fragment>
      {/* Blog Header */}
      <BlogHeader></BlogHeader>

      {/* Blog Main */}
      <div className="container App-header">
        <Routes>
          <Route path={"/"} element={<BlogMain />} />
          <Route path={"/index"} element={<BlogMain />} />

          {/*Blog Categories */}
          {/* http://localhost:3000/blog/category/list */}
          <Route path={"/blog/category/list"} element={<BlogCategoryList />} />
          <Route path={"/blog/category/create"} element={<BlogCategoryCreate />} />
          <Route path={"/blog/category/view/:id"} element={<BlogCategoryView />} />
          <Route path={"/blog/category/update/:id"} element={<BlogCategoryUpdate />} />

          {/* <Route path={"*"} element={<Navigate to={"/"}/>} /> */}
          <Route path={"*"} element={<NotFound/>} />

        </Routes>
        {/* <BlogMain></BlogMain> */}
      </div>

      {/* Blog Footer */}
      <BlogFooter></BlogFooter>
    </React.Fragment>
  ); //end return
} // end BlogRouter

// I18N
// EXPORT Hight Order Component
// export default BlogRouter;
export default withTranslation()(BlogRouter);
