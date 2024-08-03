// rfce
import React, { useState } from "react";

// I18N
import { withTranslation } from "react-i18next";

// NAVIGATE
import { useNavigate } from "react-router-dom";

// FUNCTION
function BlogCategoryCreate({ t, i18n, props }) {
  // REDIRECT
  let navigate = useNavigate();

  // STATE
  // const [categoryName, setCategoryName] = React.useState('');
  const [categoryName, setCategoryName] = useState(null);

  // Bütün Object Almak
  //const [blogCategory, setBlogCategory] = useState(null);

  // ERROR, MULTIPLEREQUEST,READ,SPINNER
  const [error, setError] = useState(undefined);
  const [multipleRequest, setMultipleRequest] = useState(false);
  const [isRead, setIsRead] = useState(false);
  const [spinner, setSpinner] = useState(false);

  ///////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////
  // FUNCTION

  // Read OnChange
  const onChangeIsRead = (event) => {
    console.log(event.target.checked);
    setIsRead(event.target.checked);
    // 1 kere okuduktan sonra okuma checkboz'ı görünmesin
    localStorage.setItem("is_read", "true");
  };

  // Form input Clear
  const clearForm = () => {
    setCategoryName(undefined);
  };

  // OnChange
  function categoryNameOnChange(event) {
    const { name, value } = event.target;
    console.log(name + " => " + value);
    setCategoryName(value);
  }

  // onSubmit PreventDefault
  const onSubmitForm = (event) => {
    // Javascriptte bir olay işlyeicisi içinde çağrıldığında olayın varsayılan eylemini gerçekleşmesini engelemek için,
    // kullanıdğımız bir işlemdir. Bu yöntem ile tarayıcını sayfayı tekrar yeniden yüklemez. Aynı zamanda, tarayıcıda belirli olayların varsayılan davranışını önlemeye yarar.
    // Form Gönderilmesini engelliyoruz. Yani Form gönderimi sırsaında sayfanın yeniden yüklenmesini engellemek için kullanılır.
    // Varsayılan davranışları engellemek için preventDefault() fonksiyonunu kullanırız.
    // Browser sen dur bir yere birşey gönder ben istersem gönderirim.
    event.preventDefault();
  };

  // Submit
  const submitBlogCategory = async () => {
    try {
      // BÜTÜN Object Almak
      // const blogCategory = { name: categoryName };
      // BENİN LOCAL STORAGE İLE KAYDETMEK İÇİN
      // localStorage.setItem("category_name", categoryName);
      // REDIRECT
      // navigate("/blog-categories", { replace: true });
    } catch (error) {
    } finally {
    }
  };

  // SPINNER FORM
  const spinnerForm = () => {
    if (spinner) {
      return (
        <div
          className="spinner-border spinner-border-sm text-primary me-2"
          role="status"
        >
          <span className="sr-only">Loading...</span>
        </div>
      );
    }else{
      return "";
    }
  };

  // ERROR
  const classNameData = { error }
    ? "is-invalid form-control mb-3"
    : "form-control mb-3";

  ///////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////
  // Return
  return (
    <React.Fragment>
      <div className="container">
        <div className="row">
          <div className="col-md-2"></div>
          <div className="col-md-8">
            <h1 className="text-center display-4 mt-4 mb-4 text-uppercase">
              {t("blog_category_create")}
            </h1>
            <p className="text-muted text-center">Blog Category</p>
          </div>
          <div className="col-md-2"></div>
          <div className="card"></div>
        </div>
      </div>
    </React.Fragment>
  );
}

// I18N
export default withTranslation()(BlogCategoryCreate);
