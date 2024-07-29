// rfce
import React from 'react'

// I18N
import { withTranslation } from 'react-i18next'

// NAVIGATE
import { useNavigate } from 'react-router-dom';

// FUNCTION
function BlogCategoryCreate({ t, i18n, props }) {

    // REDIRECT
    let navigate = useNavigate();

    // STATE
    //const [categoryName, setCategoryName] = React.useState('');
    const [categoryName, setCategoryName] = useState(null);

    // ERROR, MULTIPLEREQUEST,READ,SPINNER
    const[error,setError]=useState(undefined);
    const[multipleRequest,setMultipleRequest]=useState(undefined);
    const[isRead,setIsRead]=useState(undefined);
    const[spinner,setSpinner]=useState(undefined);

  // Return
  return (
    <React.Fragment>
            <div className="container">
        <div className="row">
          <div className="col-md-2"></div>
          <div className="col-md-8">
            <h1 className="text-center display-4 mt-4 mb-4 text-uppercase">{t('blog_category_create')}</h1>
           <p className="text-muted text-center">Blog Category</p>

          </div>
          <div className="col-md-2"></div>
          <div className="card"></div>
        </div>
      </div>
    </React.Fragment>
  )
}

// I18N
export default withTranslation()(BlogCategoryCreate);