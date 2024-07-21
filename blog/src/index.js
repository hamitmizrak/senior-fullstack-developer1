// Eğer ES5 üzerinden ilerlemek istiyorsanız katı mod olan
// "use strict";

// REACT
import React from "react";
import ReactDOM from "react-dom/client";

// ROUTER
// BrowserRouter  => http://localhost:3000/
// HashRouter     => http://localhost:3000/#
import BlogRouter from "./BlogRouter";
import { BrowserRouter } from "react-router-dom";

// Dil
import './internationalization/i18nlanguage'

// Index CSS
import "./index.css";
import reportWebVitals from "./reportWebVitals";

// Dark Mode
import './dark.css'

// ROOT
const root = ReactDOM.createRoot(document.getElementById("root"));

// RENDER
root.render(
  <React.StrictMode>
    <BrowserRouter>
      <BlogRouter> </BlogRouter>
    </BrowserRouter>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
