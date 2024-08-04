# Register işlemlerimizi yapabilmemiz için Registraation Token Aktifleştirmeliyiz.
[Registration Token Url](https://gitlab.com/groups/devops3664131/-/settings/ci_cd)
[Default Branch Name](https://gitlab.com/groups/devops3664131/-/settings/repository)

## GitLab Runner Kurulum (Windows)
-  Windows => https://docs.gitlab.com/runner/install/windows.html
-  64 bit işletim sistemini indir
- C diskinde GitLab-Runner dizinin icinde .exe dosyası olsun
- cd C:\GitLab-Runner
- bu dizin içinde gitlab-runner.exe bu dosya olmalıdır.

## GitLab Runner Kurulum (Windows) Install, Start
- powershell(Yönetici) =>   cd C:\GitLab-Runner
- powershell(Yönetici) =>  .\gitlab-runner.exe install
- powershell(Yönetici) =>  .\gitlab-runner.exe start
- powershell(Yönetici) =>  .\gitlab-runner --version
- powershell(Yönetici) =>  .\gitlab-runner.exe register 
