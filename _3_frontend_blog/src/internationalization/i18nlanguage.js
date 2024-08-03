// i18next
import i18n from 'i18next';

// initReactI18next
import {initReactI18next} from 'react-i18next';

// i18n.use()
i18n.use(initReactI18next).init({
    resources: {
        en:
            {
                translations: {
                    'home': 'Home',
                    'about': 'About',
                    'blog': 'Blog',
                    'newspaper': 'Newspaper',
                    'contact': 'Contact',
                    'login': 'Login',
                    'register': 'Register',
                    'search': 'Search',
                    'create': 'Create',
                    'create_all': 'Multiple data create',
                    'delete_all': 'All Delete',
                    'update':"Update",
                    'show':"Show",
                    'date':'Date',
                    'delete':"Delete",
                    'blog_category_list': 'Blog Category List',
                    'blog_category_update': 'Blog Category Update',
                    'blog_category_view': 'Blog Category View',
                    'blog_category_create': 'Blog Category Create',

                    'id':'id',
                    'blog_category_name':'Blog Category Name',
                    'is_read':" are you is read requirement sözleşme ?",
                    'cleaner_form':"Form Cleaner",
                }
            },
        tr:
            {
                translations: {
                    'home': 'Anasayfa',
                    'about': 'Hakkımızda',
                    'blog': 'Blog',
                    'newspaper': 'Haberler',
                    'contact': 'İletişim',
                    'login': 'Giriş',
                    'register': 'Üye Ol',
                    'search': 'Arama',
                    'create': 'Ekle',
                    'create_all': 'Çoklu veri ekle',
                    'delete_all': 'Hepsini Sil',
                    'update':"Güncelle",
                    'show':"Göster",
                    'date':"Tarih",
                    'delete':"Sil",
                    'blog_category_list': 'Blog Kategori Listesi',
                    'blog_category_update': 'Blog Kategori Güncelleme',
                    'blog_category_view': 'Blog Kategori Göster',
                    'blog_category_create': 'Blog Kategori Oluştur',
                    'id':'id',
                    'blog_category_name':'Blog Kategori Adı',
                    'is_read':"Gerekli Sözleşmeyi okunuz mu ?",
                    'cleaner_form':"Form temizle",
                }
            }
    },
    fallbackLng: 'tr',    //default olarak Türkçe (tr)
    ns: ['translations'], //kelimeleri nerede alsın
    defaultNS: 'translations',
    keySeparator: false,
    interpolation: {escapeValue: false, formatSeparator: ','},
    react: {
        wait: true
    }
});

// EXPORT
export default i18n;