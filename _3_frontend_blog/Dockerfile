# docker image build -t imageAdi .
# docker container run -d -p 3333:80 --rm --name my_imageName

# DockerHub push
# 1.adım: Postgres_Dockerfile ile image oluştur
# 2.adım: Dockerhub üzerinden repository oluştur
# 3.adım: docker ps
# image name: image_spring_react
# 4.adım: docker image tag image_spring_react javahamitmizrak/fullstack11
# 5.adım: docker push javahamitmizrak/fullstack11

#####################################################################
# FROM:  Çalıştıracağımız image adı
# Node JS Image
# FROM node:18.17.1
FROM node:alpine AS builder

# Description
LABEL maintainer="hamitmizrak@gmail.com"

# Environment Variables
ENV APP_NAME="Senior Full Stack1 Frontend"
ENV TECH="Spring Boot, React, Devops, Docker, SonarQube, Git"
ENV VERSION="v1.0.0"
ENV PORT="http://localhost:3333"
ENV AUTHOR="Hamit Mızrak"
ENV YEAR="31/07/2024"

# Running
## RUN apt-get update && apt-get upgrade -y && apt-get dist-upgrade -y
RUN echo "App Name: $APP_NAME"
RUN echo "Technology: $TECH"
RUN echo "App Version: $VERSION"
RUN echo "App Port: $PORT"
RUN echo "App Author: $AUTHOR"
RUN echo "App Year: $YEAR"

# Directory Create(Çalışma dizinini ayarlıyoruz)
WORKDIR /app

# RUN: Terminalde çalışmasını istediğimiz kısımlar
# RUN mkdir -p deneme

# Data Persist (Kalıcı Veri)
VOLUME /tmp

# Package.json dosyalarını kopyalıyoruz
# COPY ["package.json","package-lock.json","./"]  => 2.YOL
COPY package*.json ./

# Running Continue
RUN node -v
RUN npm -v
RUN npm -g list
RUN ls

# RUN mvn -v

# NPM Install
RUN npm install -g typescript

# RUN npm install --production komutu, Postgres_Dockerfile'da kullanıldığında,
# Node.js uygulamanızın yalnızca üretim bağımlılıklarını yükler.
# Bu, uygulamanızın geliştirici bağımlılıkları olmadan çalışmasını sağlar,
# böylece Docker imajının boyutu küçülür ve daha güvenli bir üretim ortamı oluşturulur.
# --production: Bu bayrak, yalnızca dependencies kısmında belirtilen bağımlılıkları yükler.
# devDependencies kısmındaki bağımlılıklar yüklenmez.
# Bu, uygulamanızın yalnızca üretim için gerekli olan bağımlılıkları yüklemesini sağlar.
# Bu komut genellikle Postgres_Dockerfile'da kullanılır, çünkü üretim ortamında geliştirici bağımlılıklarına ihtiyaç duyulmaz
RUN npm install --production


# Clear Cache
# RUN apt-get clean  && rm -rf /var/lib/apt/lists/*

# COPY (Uygulama dosyalarını kopyalıyoruz)
# COPY . . komutu, Postgres_Dockerfile'da kullanılan bir talimattır ve iki noktadan oluşur.
# Bu kaynaklardan 1. nokta:kaynaktır 2.nokta hedeftir.
# Bu komut, kaynak dizinindeki tüm dosya ve klasörleri, hedef dizinine kopyalar.
# İşte bu komutun ne yaptığına dair bir detaylı açıklama:
#İlk nokta (.): Docker build komutunun çalıştırıldığı dizini temsil eder,
# yani Docker build komutunu çalıştırdığınız dizindeki tüm dosya ve klasörler.
#İkinci nokta (.): Docker konteynerindeki çalışma dizinini temsil eder (WORKDIR ile belirlenen dizin).
COPY . .

# Uygulamayı build ediyoruz
# Genellikle, bu komut, proje dosyalarını derler, minimize eder ve üretim için optimize eder.
# Örneğin, React uygulamasında bu komut, src dizinindeki dosyaları alır ve optimize edilmiş, dağıtıma hazır statik dosyalar oluşturur.
RUN npm run build

# 1<=PORT<=1023
# 1023<=PORT<=49151
# 49151<=PORT<=65535

# EXPOSE
# 80  = Web dış dünyaya açılış yeridir
# 443 = SSL Sertifates
# EXPOSE 80 443

#######################################################################################################
#######################################################################################################
# Production aşaması
FROM nginx:alpine

# Nginx konfigürasyon dosyasını kopyalıyoruz
COPY nginx.conf /etc/nginx/conf.d/default.conf


# Build edilmiş dosyaları kopyalıyoruz. Bu komut silsilesinde  Node.js yapılarında bir nginx sunucusunda barındırmak içindir.
# İlk aşamada(builder) sonra uygulama dosyalarını oluşturuyoruz ve nginx ile reverse proxy yapıyoruz.
# Bu komut, Dockerfil eiçindeki bir COPY komutudur.
# --from=builder => Bu komut, çok aşamlı bit yapı sürecinde iken, bir önceki aşamda tanımlanan bir imaj dosyasından dosya kopyalamak anlamına gelir
# Bu aşamada ise genelllikle bağımlılıkların ve uygulamanın derlenemesinde kullanılmaktadır.
# /app/build => builder aşamasında oluşturulmuş olan kaynak dosyalarının konumunu belirlemek için kullanılır.
# /usr/share/nginx/html => Kopyalanacak dosyaların hedef konumu belirtir. Yani /usr/share/nginx/html içindeki dosyayla değiştir.
COPY --from=builder /app/build /usr/share/nginx/html

# Nginx'i başlatıyoruz.
# Docker konteynarı başlatıldığında çalışacak varsayılan komuttur.
# CMD=>  Yalnızca bir kez tanımlanır ve konteynar çalıştığında eğer override(Ezme) yapılmadıkca çalışır.
# "nginx", => Nginx web sunucusunu çalıştırağı yapıdır.
# "-g" => Nginx'i  'i doğrudan global yapılandırmasıdır.
# "daemon off;" =>  Nginx'i arka planda daemon mode çalışmasını engelleyen bir direktiftir(Emirdir)
# daemon mode'un yerine Nginx ön planda çalışsın
# Kısaca: Docker, bir konteynarın ana işlemini yapıp sona erdiğinde durdurulur.
# Duran bu yapının yerinde ön planda Nginx çalışmaya devam eder
CMD ["nginx", "-g", "daemon off;"]

# CMD
# CMD ["npm","start"]

# HEALTHCHECK => Bu image dosyasının sağlık durumu (Container Çalışıyor mu)
# --interval=30s  ==> 30 saniyede bir sağlık kontrolü yapılsın
# --timeout=3s  ==>  10 saniyede Sağlık kontrolünü tamamlasın
# --start-periyod=5s  ==> Konteynar başladığında sağlık kontrolünün başlamasın için 5 saniye bekle
# --retries=3  ==>  Sağlık kontrolünü eğer ilk denemede başarısız olursa 3 defa daha  çalışsın.
# Eğer bu 3s komutu belirtilenin dışına çıkarsa Docker sağlıksız olarak işaretlenir
# CMD wget --quiet --tries=1 --spider http://localhost : wget ile localhost istek atmak
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
    CMD wget --quiet --tries=1  --spider http://localhost:80 || exit 1

##########################################################################################################
##########################################################################################################

# Başka zaman buraya Maven ekle

##########################################################################################################
##########################################################################################################
# docker build -t imageName .
# docker build -f CustomizeDockerFile -t imageName .

# docker container ls
# docker container ls -a
# docker ps
# docker ps -a
# docker container run -p 3333:80 blog
# docker container run -p 3333:80 --name react_blog blog
# docker container run -d -p 5555:4444 --name react_blog blog
# docker container run --rm -d -p 6666:4444 --name react_blog blog
# docker container prune
# docker container exec -it containerID bash
