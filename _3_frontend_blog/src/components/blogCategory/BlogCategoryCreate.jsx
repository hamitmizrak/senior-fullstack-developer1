// rfce
import React, { useState } from "react";

// I18N
import { withTranslation } from "react-i18next";

// NAVIGATE
import { useNavigate } from "react-router-dom";

// API CALLS (asyn-await)
import BlogCategoryApi from "../../services/BlogCategoryApi";

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
  }; //end onChangeIsRead

  // Form input Clear
  const clearForm = () => {
    setCategoryName(undefined);
  }; //end clearForm

  // OnChange
  function onChangecategoryName(event) {
    const { name, value } = event.target;
    console.log(name + " => " + value);
    setCategoryName(value);
  } // end categoryNameOnChange

  // onSubmit PreventDefault
  const onSubmitForm = (event) => {
    // Javascriptte bir olay işlyeicisi içinde çağrıldığında olayın varsayılan eylemini gerçekleşmesini engelemek için,
    // kullanıdğımız bir işlemdir. Bu yöntem ile tarayıcını sayfayı tekrar yeniden yüklemez. Aynı zamanda, tarayıcıda belirli olayların varsayılan davranışını önlemeye yarar.
    // Form Gönderilmesini engelliyoruz. Yani Form gönderimi sırsaında sayfanın yeniden yüklenmesini engellemek için kullanılır.
    // Varsayılan davranışları engellemek için preventDefault() fonksiyonunu kullanırız.
    // Browser sen dur bir yere birşey gönder ben istersem gönderirim.
    event.preventDefault();
  }; //end onSubmitForm

  // Submit
  const submitBlogCategory = async (event) => {
    // Blog Category Create Object
    const blogCategoryCreateObject = {
      categoryName,
    };
    console.log(blogCategoryCreateObject);

    // Hataları Göstermek
    setError(null);

    // Spinner'ı Açıyoruz(Aktif ediyoruz)
    setSpinner(true);

    // Multiple Request'ı Başlangıçta açıyoruz(Aktif ediyoruz)
    setMultipleRequest(true);

    // API İLE İLGİLİ İŞLEMLERİ YAPIYORUZ
    try {
      //const response = await fetch("https://api.example.com/blog/category", {});
      const response = await BlogCategoryApi.categoryApiCreate(
        blogCategoryCreateObject
      );
      if (response.status === 200) {
        //Spinner'ı Kapıyoruz(Pasif ediyoruz)
        setSpinner(false);

        // Multiple Request'ı Başlangıçta kapatıyoruz(Pasif ediyoruz)
        setMultipleRequest(false);

        // Yeni Kayıt başarılıysa
        window.alert("Blog kategori başarıyla oluşturuldu.");
        navigate("/blog/category/list");
      } else {
        window.alert("Blog kategori oluşmadı!!!");
      }
    } catch (error) {
      // Hataları Gösteriyoruz
      setError(error.response.data.validationErrors);

      // Hata varsa Spinner'ı Açıyoruz(Aktif ediyoruz)
      setSpinner(true);

      // Multiple Request'ı Başlangıçta kapatıyoruz(Pasif ediyoruz)
      setMultipleRequest(false);
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
    } else {
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
      <div className="container mt-5 mb-5">
        <div className="row">
          <div className="col-md-2"></div>
          <div className="col-md-8">
            <h1 className="text-center display-4 mt-4 mb-4 text-uppercase">
              {t("blog_category_create")}
            </h1>
            <p className="text-muted text-center">Blog Category</p>
            {/* FORM */}
            {/* event.preventDefault(); */}
            <form onSubmit={onSubmitForm}>
              <div className="d-grid gap-4">
                {/* FORM GROUP */}
                <div className="form-group">
                  {/* LABEL */}
                  <label htmlFor="categoryName">
                    {t("blog_category_create")}
                  </label>

                  {/* INPUT */}
                  <input
                    type="text"
                    className={classNameData}
                    id="categoryName"
                    name="categoryName"
                    placeholder={t("blog_category_create")}
                    autoFocus={true}
                    required={true}
                    onChange={onChangecategoryName}
                  />
                  {/* input end */}

                  {/* ALERT ERROR */}
                  {error ? (
                    <div className="invalid-feedback">{error.categoryName}</div>
                  ) : (
                    ""
                  )}
                </div>
                {/* EĞER OKUNMUŞSA BİR KERE DAHA GÖSTERME */}
                {localStorage.getItem("is_read") === "true" ? (
                  ""
                ) : (
                  <span style={{ display: "inline" }}>
                    <input
                      type="checkbox"
                      className="form-check-input"
                      onChange={onChangeIsRead}
                      name="isRead"
                      id="isRead"
                    />
                    <abbr title={t("is_read")} htmlFor="isRead">
                      {t("is_read")}
                    </abbr>
                  </span>
                )}{" "}
                {/* checkbox end */}

                {/* RESET BUTTON */}
                <button
                  type="reset"
                  onClick={clearForm}
                  className="btn btn-danger mt-5 me-2"
                >
                  t('cleaner_form')
                </button>

{/* SUBMIT BUTTON */}


              </div>{" "}
              {/* d-grid gap-4 end */}
            </form>{" "}
            {/* form end */}
          </div>{" "}
          {/* col-md-8 end */}
          <div className="col-md-2"></div>
          <div className="card"></div>
        </div>{" "}
        {/* row end */}
      </div>{" "}
      {/* container end */}
    </React.Fragment>
  );
}

// I18N
export default withTranslation()(BlogCategoryCreate);
