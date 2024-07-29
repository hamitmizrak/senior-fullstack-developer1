// rfce
import React, { useEffect, useState } from "react";

//REDIRECT
import { useNavigate } from "react-router-dom";

// FUNCTION
function BlogCategoryList({ t, i18n, props }) {
  // REDIRECT
  let navigate = useNavigate();

  // STATE
  const [blogCategoryApiImplListData, setBlogCategoryApiImplListData] =
    useState([]);

  // EFFECT
  useEffect(() => {
    // fetchBlogCategoryApiImplListData();
  }, []);

  // API CALLS
  const fetchBlogCategoryApiImplListData = () => {}; //end fetchBlogCategoryApiImplListData
  ///////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////

  // FUNCTION

  ///////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////
  // return
  return <div>BlogCategoryList</div>; //end return
} //end BlogCategoryList

// EXPORT
export default BlogCategoryList;
