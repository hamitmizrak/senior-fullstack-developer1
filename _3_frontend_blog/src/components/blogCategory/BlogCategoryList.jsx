// rfce
import React, { useEffect, useState } from "react";
import { withTranslation } from "react-i18next";

//REDIRECT
import { Link, useNavigate } from "react-router-dom";
import BlogCategoryApi from "../../services/BlogCategoryApi";

// FUNCTION
function BlogCategoryList({ t, i18n, props }) {
  // REDIRECT
  let navigate = useNavigate();

  // STATE
  const [blogCategoryApiImplListData, setBlogCategoryApiImplListData] =
    useState([]);

  // EFFECT
  useEffect(() => {
    fetchBlogCategoryApiImplListData();
  }, []);

  // API CALLS (asyn-await)
  const fetchBlogCategoryApiImplListData = async () => {
    try {
      const response = await BlogCategoryApi.categoryApiList();
      setBlogCategoryApiImplListData(response.data);
    } catch (error) {
      console.error("Error fetching blogCategoryApiImplListData: ", error);
    }
  }; //end fetchBlogCategoryApiImplListData
  ///////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////

  // FUNCTION (promise)
  // Listeden eğer bir manipulation(değiştirirsem) liste güncel halini göstersin.
  const listManipulationAfter = () => {
    BlogCategoryApi.categoryApiList()
      .then((response) => {
        console.log(response);
        console.log(response.data);
        console.log(response.status);
        console.log(response.headers);
        if (response.status === 200) {
          setBlogCategoryApiImplListData(response.data);
        }
      })
      .catch((error) => {
        error.message && console.error("Error: ", error.message);
      });
  };

  ///////////////////////
  // SPEED DATA
  // DELETE ALL DATA

  ///////////////////////
  // LOCAL STORAGE VIEW-ID
  const localStorageViewBlogCategoryId = (id) => {
    // 1.YOL (id=> useParams)
    // 2.YOL (id=> localStorage)
    localStorage.setItem("view_blogCategory_Id", id);
  };

  // LOCAL STORAGE UPDATE-ID
  const localStorageUpdateBlogCategoryId = (id) => {
    // 1.YOL (id=> useParams)
    // 2.YOL (id=> localStorage)
    localStorage.setItem("update_blogCategory_Id", id);
  };

  ///////////////////////
  // BLOG CATEGORY DELETE
  const setDeleteBlogCategory = (id) => {
    if (window.confirm(id + " nolu blog category'i Silmek istiyor musunuz ?")) {
      BlogCategoryApi.categoryApiDeleteById(id)
        .then((response) => {
          if (response.status === 200) {
            listManipulationAfter();
            navigate("/blog/category/list"); //1.YOL
            // window.location="/blog/category/list"; //2.YOL
          }
        })
        .catch((err) => {
          console.error("Error: ", err.message);
          window.alert("Blog kategori silinirken hata oluştu.");
          err.message && console.error("Error: ", err.message);
          window.location = "/blog/category/list";
          //return; // İşlem iptal edilirse return yapıyoruz.
        });
    } else {
      window.alert("Silme işlemi iptal edildi.");
      window.location = "/blog/category/list";
    }
  };

  ///////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////
  // return
  return (
    <React.Fragment>
      <h1 className="text-center display-5 mb-5">{t("blog_category_list")}</h1>
      <Link className="btn btn-primary me-2" to="/blog/category/create">
        {t("blog_category_create")}
      </Link>
      <table className="table table-striped table-responsive mb-4">
        <thead>
          <tr>
            <th>{t("id")}</th>
            <th>{t("blog_category_name")}</th>
            <th>{t("date")}</th>
            <th>{t("update")}</th>
            <th>{t("show")}</th>
            <th>{t("delete")}</th>
          </tr>
        </thead>

        <tbody>
          {blogCategoryApiImplListData.map((item) => (
            <tr key={item.categoryId}>
              <td>{item.categoryId}</td>
              <td>{item.categoryName}</td>
              {/* <td>{new Date(item.createdAt).toLocaleString()}</td> */}
              <td>{item.systemCreatedDate}</td>
              <td>
                <Link
                  className="btn btn-warning"
                  to={`/blog/category/update/${item.categoryId}`}
                  onClick={() =>
                    localStorageUpdateBlogCategoryId(item.categoryId)
                  }
                >
                  {t("update")}
                </Link>
              </td>

              <td>
                <Link
                  className="btn btn-info"
                  to={`/blog/category/view/${item.categoryId}`}
                  onClick={() =>
                    localStorageViewBlogCategoryId(item.categoryId)
                  }
                >
                  {t("show")}
                </Link>
              </td>

              <td>
                <Link
                  className="btn btn-danger"
                  onClick={() => setDeleteBlogCategory(item.categoryId)}
                >
                  {t("delete")}
                </Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
  
    </React.Fragment>
  ); //end return
} //end BlogCategoryList

// EXPORT
export default withTranslation()(BlogCategoryList);
