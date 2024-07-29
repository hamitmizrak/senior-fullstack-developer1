// rfce
import React, { useEffect, useState } from "react";
import { withTranslation } from "react-i18next";
import { useNavigate, useParams } from "react-router-dom";

// Pictures
import image from "../../assets/image/sunset.jpg";
import BlogCategoryApi from "../../services/BlogCategoryApi";

// FUNCTION
function BlogCategoryView({ t, i18n, props }) {

  // REDIRECT
  let navigate = useNavigate();

  // STATE
  const [blogCategoryId, setBlogCategoryId] = useState(null);
  const [blogCategoryView, setBlogCategoryView] = useState([]);

  // PARAMS(ID)
  const parametersHandlingViewId = useParams();

  // EFFECT
  useEffect(() => {
    // 1.YOL (ID => LocalStorage)
    setBlogCategoryId(localStorage.getItem("view_blogCategory_Id"));

    // 2.YOL (ID=> userParams)
    //setBlogCategoryId(parametersHandlingViewId.id);

    //CATEGORY NAME FIND BY ID
    BlogCategoryApi.categoryApiFindById(parametersHandlingViewId.id)
      .then((response) => {
        console.log(response);
        console.log(response.data);
        console.log(response.status);
        console.log(response.headers);
        if (response.status === 200) {
          setBlogCategoryView(response.data);
        }
      })
      .catch((error) => {
        error.message && console.error("Error: ", error.message);
      });
  }, []); //end useEffect

  // return
  return (
    <React.Fragment>
      <div className="container">
        <div className="row">
          <div className="col-md-2"></div>
          <div className="col-md-8">
            <h1 className="text-center display-4 mt-4 mb-4 text-uppercase">{t('blog_category_view')}</h1>
            <img
              className="card-img-top"
              src={image}
              alt={blogCategoryView.categoryName}
            />
            <div className="card-body">
              <h4 className="card-title text-center">{blogCategoryView.categoryId}</h4>
              <p className="card-text text-center">{blogCategoryView.categoryName}</p>
              <span className="text-muted float-end">{blogCategoryView.systemCreatedDate}</span>
            </div>
          </div>
          <div className="col-md-2"></div>
          <div className="card"></div>
        </div>
      </div>
    </React.Fragment>
  );
}

// I18N
export default withTranslation()(BlogCategoryView);
