# GitLab Nedir ?
- Yazılım geliştirme süreçlerini yönetmek için 
- kodlarımızı saklamak için  
- web tabanlı git reposudur.
- Projemizin yönetimi, izlenmesi için çok önemlidir.
- Sürekli Entegrasyon (CI) Continues Integration => build, test
- Sürekli Dağıtım (CD) Continues Deployment, Continues Delivery => Dağıtım
- Ücretsizdir
- Web tabanlıdır.
- Kendi sunucularınızda barındırabilirsiniz.
- CI/CD özelliği vardır.
- public, private yapabiliriz.
---

## GitLab Temel Özellikler
> Versiyon Kontrol sistemidir.
> Aynı anda birden fazla kişi çalışabilir (Dağıtık sistem)
> Proje kodlar takibini sağlayabiliriz.
> Branch, merge
> Wiki
> Gitlab, API,webhook bunlarla beraber diğer araçlarla entegrasyon sağlayabiliriz.
---

## GitLab Sürümleri
### 1- GitLab CE (Community Edition)
- Açık kaynak kodludur.
- Ücretsizdir.
- Temel özelliklerinin bir çoğunu içermektedir.
- On-Preme yani kendi sunucularımızda saklayabiliriz.

### 2- GitLab EE (Enterprise Edition)
- Ücretlidir
- Büyük ölçekli kurumsal projelerde GitLab CE üzerinde ek özelliklerle gelmektedir.

### GitLab Kullanım Alanları
- Backend
- Frontend
- Devops: CI/CD
- Issues, Wiki

## GitLab Runner
- GitLab Runner CI/CD süresinde çok önemli bir rola sahip ajandır.
- Local bilgisayarımızda olup biten herşeyi gitlab server iletir.
- GitLab runnerların her biri birbirinden izolasyonludur.
- Go diliyle yazılmıştır.
- Cross Platform yapıya sahiptir.
- windows, MacOs, Linux üzerinde de gitlab runner kurabilirsiniz.
- MIT lisansına sahiptir.

## GitLab Runner Kurulum (Windows)
-  Windows => https://docs.gitlab.com/runner/install/windows.html 
-  64 bit işletim sistemini indir
- C diskinde GitLab-Runner dizinin icinde .exe dosyası olsun
- cd C:\GitLab-Runner
- bu dizin içinde gitlab-runner.exe bu dosya olmalıdır.

## GitLab Runner Kurulum (Windows) Install, Start
- powershell(Yönetici) =>  .\gitlab-runner.exe install
- powershell(Yönetici) =>  .\gitlab-runner.exe start
- powershell(Yönetici) =>  .\gitlab-runner --version


## GitLab Runner Registraction Token (Windows) New project runner
- Tags: Bu alan runner'a atanan etiketlerdir. 
- Bu etiketlerde belirlediğimiz isimler sadece o runnerda çalışmasına izin verecektir.
- Örneğin: windows => işletim sistemi windows olan etiketlerde sadece çalışır.
- Etiketlerde virgüllerle ayırmaktayız.

- Configuration (optional):
- Runner description: Runner açıklayısıdır. Buraya hangi işlem yapacağımızı yazıyoruz.
- Paused: Runner yeni işleri kabul etmez.
- Protected: Runner yalnızca protected branches(yalnızca private olmuş branchler üzerinde çalışır)
- Lock to current projects: Runner yalnızca şu anda atandığı projeler için kullanırız. Bu runner çeşitinde diğer projelerde kullanılmasını engeller ve güvenliği artırır.

- Maximum job timeout: Runner tarafından çalıştırılan job(işler) Maksimum zaman aşımını belirtmemize olanak sağlar.
- Eğer bu süre dolarsa iş otomatik olarak durur.
- minimum of 600 seconds.

- Tag Name: windows,spring,react
- Windows OS
- .\gitlab-runner.exe register  --url https://gitlab.com  --token glrt-vs3CMoAs4aZW4sRCum9z


## GitLab Runner Kurulum (Windows)  Register
- powershell(Yönetici) =>  .\gitlab-runner.exe register



# GitLab Konu başlıkları
- Issue Management
- Wiki
- GitLab Pipeline
- Gitlab Flow
- Gitlab CI/CD
- deployment
- Create Group
- Access Token
- SSH Keys
- GPG Keys
---

## GitLab Push
```sh 
cd existing_repo
git remote add gitlab https://gitlab.com/devops3664131/SpringBoot.git
git branch -M main
git push -uf gitlab main
```

git remote 
git remote -v
origin  https://github.com/hamitmizrak/senior-fullstack-developer1.git (fetch)
origin  https://github.com/hamitmizrak/senior-fullstack-developer1.git (push)



## GitLab Ayar Menüsü
- Access Tokens: API erişimi için token oluşturabilirsiniz ve Hitlab API erişim sağlarken kullanırsınız
- SSH Keys: SSH (Güvenli kabuk) Gitlab ile repo arasında güvenli bağlantı
- GPG Keys: Bu anahtar türünde commitlerini digital olarak imzalamak ve kimliğimizi doğrulamak
---

##


