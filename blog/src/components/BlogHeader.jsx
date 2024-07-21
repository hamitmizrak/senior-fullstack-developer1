// rfce

// HEADER
// REACT
import React from "react";

// Link
import { Link } from "react-router-dom";

// i18N
import { withTranslation } from "react-i18next";

// Dil için (Reusability)
import OtherLanguageReusability from "../internationalization/OtherLanguageReusability";

// Admin Function
function admin() {
  return (
    <li className=" lg:mb-0 lg:pr-2" data-te-nav-item-ref="">
      {/* Dashboard link */}
      {/* User avatar */}
      <img
        src="https://tecdn.b-cdn.net/img/new/avatars/2.jpg"
        className="rounded-full"
        style={{ height: 25, width: 25 }}
        alt=""
        loading="lazy"
      />
    </li>
  );
}

// FUNCTION HEADER
function BlogHeader({ props, t, i18n }) {
  return (
    <React.Fragment>
      {/* Start Navbar */}
      <nav className="fixed-top navbar navbar-expand-sm navbar-dark bg-dark">
        <div className="container">
          <Link className="navbar-brand" to="/index">
          
          </Link>
          <button
            className="navbar-toggler d-lg-none"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#collapsibleNavId"
            aria-controls="collapsibleNavId"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span className="navbar-toggler-icon" />

            {/* 'home': 'Home',
                    'about': 'About',
                    'blog': 'Blog',
                    'newspaper': 'Newspaper',
                    'contact': 'Contact', {t('login')} */}
          </button>
          <div className="collapse navbar-collapse" id="collapsibleNavId">
            <ul className="navbar-nav me-auto mt-2 mt-lg-0">
              <li className="nav-item">
                <Link
                  className="nav-link active"
                  aria-current="page"
                  to="/index"
                >
                  {t("home")}
                  <span className="visually-hidden">(current)</span>
                </Link>
              </li>

              <li className="nav-item">
                <a className="nav-link" href="#">
                  {t("about")}
                </a>
              </li>

              <li className="nav-item">
                <Link className="nav-link" to="/blog/category/list">
                  {t("blog")}
                </Link>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="#">
                  {t("newspaper")}
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="#">
                  {t("contact")}
                </a>
              </li>

              {/* <li className="nav-item dropdown">
                <a
                  className="nav-link dropdown-toggle"
                  href="#"
                  id="dropdownId"
                  data-bs-toggle="dropdown"
                  aria-haspopup="true"
                  aria-expanded="false"
                >
                  Dropdown
                </a>
                <div className="dropdown-menu" aria-labelledby="dropdownId">
                  <a className="dropdown-item" href="#">
                    Action 1
                  </a>
                  <a className="dropdown-item" href="#">
                    Action 2
                  </a>
                </div>
              </li> */}
            </ul>
            <form className="d-flex my-2 my-lg-0">
              <input
                className="form-control me-sm-2"
                type="text"
                placeholder={t("search")}
              />
              <button
                className="btn btn-outline-success my-2 my-sm-0"
                type="submit"
              >
                {t("search")}
              </button>
            </form>

            <ul className="navbar-nav me-auto44 mt-2 mt-lg-0">
              <li className="nav-item dropdown">
                <a
                  className="nav-link dropdown-toggle"
                  href="#"
                  id="dropdownId"
                  data-bs-toggle="dropdown"
                  aria-haspopup="true"
                  aria-expanded="false"
                >
                  {t("login")}
                </a>
                <div className="dropdown-menu" aria-labelledby="dropdownId">
                  <Link className="dropdown-item" to="/login">
                    {t("login")}
                  </Link>

                  <Link className="dropdown-item" to="/register">
                    {t("register")}
                  </Link>
                </div>
              </li>
            </ul>

            {/* i18N */}
            <OtherLanguageReusability />

            {/* ADMIN */}
            {admin()}
          </div>
        </div>
      </nav>
    </React.Fragment>
  );
}

// Export
export default withTranslation()(BlogHeader);
