// rfce
import React, { useEffect, useState } from "react";

// NAVIGATE
import { useNavigate } from "react-router-dom";

// I18N
import { withTranslation } from "react-i18next";

// API CALLS (asyn-await)
import BlogCategoryApi from "../../services/BlogCategoryApi";

// Function BlogCategoryCreate
function BlogCategoryCreate({ t, i18n, props }) {
  // REDIRECT
  const navigate = useNavigate();

  // STATE
  const [categoryName, setCategoryName] = useState(null);

  //  ERROR, MULTIPLEREQUEST, READ, SPINNER
  const [error, setError] = useState(undefined);
  const [multipleRequest, setMultipleRequest] = useState(false);
  const [isRead, setIsRead] = useState(false);
  const [spinner, setSpinner] = useState(false);

  // USE EFFECT
  // useEffect(() => {
  //   // başlangıçta Hatayı gösterme
  //   setError(undefined);
  //   setIsRead(false);
  //   setSpinner(false);
  // }, [])

  ///////////////////////////////////////////////////////////////////////
  ///////////////////////////////////////////////////////////////////////
  // FUNCTION
  // Read On Change
  const onChangeIsRead = (event) => {
    //console.log(event.target.checked);
    setIsRead(event.target.checked);
    // 1 kere okuduktan sonra okuma checkbox'ı görünmesin
    localStorage.setItem("is_read", "true");
  };

  // Form input Clear
  const inputListClear = () => {
    setCategoryName(undefined);
  };

  // OnChange
  const categoryNameOnChange = (event) => {
    const { name, value } = event.target;
    console.log(name + " " + value);
    setCategoryName(value);
  };

  // onSubmit PreventDefault
  const onSubmitForm = (event) => {
    // Javascriptte bir olay işlyeicisi içinde çağrıldığında olayın varsayılan eylemini gerçekleşmesini engelemek için,
    // kullanıdğımız bir işlemdir. Bu yöntem ile tarayıcını sayfayı tekrar yeniden yüklemez. Aynı zamanda, tarayıcıda belirli olayların varsayılan davranışını önlemeye yarar.
    // Form Gönderilmesini engelliyoruz. Yani Form gönderimi sırsaında sayfanın yeniden yüklenmesini engellemek için kullanılır.
    // Varsayılan davranışları engellemek için preventDefault() fonksiyonunu kullanırız.
    // Browser sen dur bir yere birşey gönder ben istersem gönderirim.
    event.preventDefault();
  }; //end onSubmitForm

  //// SUBMIT
  // blogCategoryCreateSubmit
  const blogCategoryCreateSubmit = async (event) => {
    // Blog Category Create Object
    const blogCategoryCreateObject = {
      //categoryName:categoryName
      categoryName,
    };
    //console.log(registerCreateObject);

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
        alert("Kayıt Başarılı");
        navigate("/blog/category/list");
      }
    } catch (err) {
      // Hataları Gösteriyoruz
      setError(err.response.data.validationErrors);
      console.error(error.response.data.validationErrors);

      // Hata varsa Spinner'ı Açıyoruz(Aktif ediyoruz)
      setSpinner(true);

      // Multiple Request'ı Başlangıçta kapatıyoruz(Pasif ediyoruz)
      setMultipleRequest(false);
    }
  }; //end blogCategoryCreateSubmit

  // Spinner
  const spinnerFunction = () => {
    if (spinner) {
      return (
        <div
          className="spinner-border  spinner-border-sm text-warning me-2"
          role="status"
        ></div>
      );
    } else {
      return "";
    }
  };

  //Error
  const classNameData = { error }
    ? "is-invalid form-control mb-3"
    : "form-control mb-3";

  //console.log(error);


  // RETURN
  return (
    <React.Fragment>
      <div className="mt-5 mb-5">
        <form onSubmit={onSubmitForm}>
          {/* <form onSubmit="event.preventDefault()"> */}
          <div className="d-grid gap-4">
            {/* NICKNAME */}
            <div className="form-group">
              <label htmlFor="categoryName"> {t("blog_category_name")}</label>
              <input
                type="text"
                className={classNameData}
                id="categoryName"
                name="categoryName"
                placeholder={t("blog_category_name")}
                autoFocus={true}
                required={true}
                onChange={categoryNameOnChange}
                /*onChange={
                  (event) => {
                        const { name, value } = event.target;
                      //console.log(`${name} => ${value}`);
                      categoryNameOnChange(event.target.value);
                    }
                 }*/
              />
              {/* ALERT ERROR */}
              {/* { errorAlert(registerNickName) } */}
              {error ? (
                <div className="invalid-feedback">{error.categoryName}</div>
              ) : (
                ""
              )}
            </div>
          </div>

          {/* READ */}
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
              <abbr title="Register Olurken Kayıt işlemleri" htmlFor="isRead">
                {t("is_read")}
              </abbr>
              <br />
            </span>
          )}

          {/* RESET */}
          <button
            type="reset"
            onClick={inputListClear}
            className="btn btn-danger text-hamitmizrak-red mt-2 me-2"
          >
            {t("cleaner")}
          </button>

          {/* SUBMIT   */}
          <button
            type="submit"
            onClick={blogCategoryCreateSubmit}
            className="btn text-hamitmizrak-blue btn-primary mt-2 me-2"
            disabled={
              !localStorage.getItem("is_read") === true || multipleRequest
            }
          >
            {/* SPINNER */}
            {spinnerFunction()}
            {t("submit")}
          </button>
        </form>
      </div>
    </React.Fragment>
  ); // end return
} // end functıon

// Export i18n Wrapper
export default withTranslation()(BlogCategoryCreate);
