# Snippet 
- Proje kodlarımızın embedded olarak görmemizi sağlayan bir statik web site mantığında görebiliriz.

---
- **GitLab Snippet**, kod parçacıkları ve diğer içerikleri paylaşmak için kullanılan bir özelliktir. 
- **Snippet'ler**, belirli kod parçalarını, komut dosyalarını veya yapılandırma dosyalarını GitLab üzerinde hızlıca paylaşmanın ve saklamanın kolay bir yolunu sunar. 

Aşağıda, GitLab Snippet oluşturma ve kullanma sürecini adım adım açıklayacağım.
### GitLab Snippet Özellikleri
- **Kişisel veya Proje Tabanlı:** Snippet'ler kişisel hesap altında veya belirli bir proje kapsamında oluşturulabilir.
- **Gizlilik Ayarları:** Snippet'ler herkese açık (public), özel (private) veya yalnızca dahili kullanıcılar tarafından görülebilir (internal) olarak ayarlanabilir.
- **Çoklu Dosya Desteği:** Birden fazla dosya içerebilir, böylece birden çok ilgili kod parçası tek bir Snippet'te saklanabilir.
- **Sürüm Kontrolü:** Snippet'ler üzerinde değişiklik yapılıp önceki versiyonlar korunabilir.
- **Kolay Paylaşım:** Oluşturulan Snippet'ler, belirli bir bağlantı aracılığıyla kolayca paylaşılabilir.

### GitLab Snippet Nasıl Oluşturulur?
#### Adım 1: Snippet Oluşturma Sayfasına Gitme
1. GitLab ana sayfasına gidin ve hesabınıza giriş yapın.
2. Sol panelden **Snippets** seçeneğine tıklayın. Eğer proje kapsamında bir Snippet oluşturmak istiyorsanız, ilgili projeye gidin ve üst menüden **Repository** altındaki **Snippets** seçeneğine tıklayın.

#### Adım 2: Yeni Snippet Oluşturma
1. **New Snippet** butonuna tıklayın. Bu, yeni bir Snippet oluşturma sayfasını açacaktır.
2. **Title** ve **Description**: Snippet için başlık ve açıklama girin. Bu bilgiler, Snippet'in ne hakkında olduğunu ve hangi amaçla kullanıldığını açıklamak için önemlidir.

#### Adım 3: Kod Parçalarını Ekleyin
1. **File name**: Eklemek istediğiniz dosya veya kod parçasının adını girin.
2. **Content**: Kod parçasını veya içeriği buraya yapıştırın. GitLab, farklı programlama dilleri için sözdizimi vurgulaması yapabilir.
3. Daha fazla dosya eklemek istiyorsanız, **Add another file** butonuna tıklayarak yeni dosyalar ekleyebilirsiniz.

#### Adım 4: Gizlilik Ayarlarını Belirleyin
1. **Visibility Level**: Snippet'in kimler tarafından görülebileceğini ayarlayın.
    - **Private**: Sadece siz görebilirsiniz.
    - **Internal**: Sadece oturum açmış GitLab kullanıcıları görebilir.
    - **Public**: Herkes görebilir.

#### Adım 5: Snippet'i Kaydedin
- **Create Snippet** butonuna tıklayarak Snippet'inizi oluşturun. Bu, Snippet'inizi kaydedecek ve paylaşılabilir hale getirecektir.

### GitLab Snippet Kullanımı
- **Erişim ve Paylaşım:** Snippet oluşturulduktan sonra, URL'si üzerinden erişebilir ve paylaşabilirsiniz.
- **Düzenleme:** Snippet'i daha sonra düzenlemek isterseniz, Snippet sayfasına gidip **Edit** seçeneğini kullanabilirsiniz.
- **Yorum Yapma:** Diğer kullanıcılar Snippet'inize yorum yapabilir, böylece geri bildirim alabilirsiniz.

### Snippet Kullanım Örnekleri
1. **Küçük Kod Parçacıkları:** Tek bir fonksiyon, algoritma veya kısa bir betik paylaşmak için idealdir.
2. **Yapılandırma Dosyaları:** `docker-compose.yml`, `.gitlab-ci.yml` gibi yapılandırma dosyalarını saklamak ve paylaşmak için kullanılabilir.
3. **Hızlı Prototipler:** Hızlıca denemek istediğiniz kodlar için kullanılabilir.
4. **Dokümanlar:** Küçük döküman veya rehberler oluşturulabilir.

### Özet
GitLab Snippet, kod parçacıklarını ve dosyalarını kolayca saklama ve paylaşma imkanı sunar. Her türlü küçük ve paylaşıma uygun içerik için uygundur ve GitLab'ın sürüm kontrolü özellikleriyle birlikte kullanılabilir. Projelerinizdeki küçük kod parçalarını ya da yapılandırma dosyalarını hızlı bir şekilde paylaşmak ve yönetmek için Snippet'leri kullanabilirsiniz.
