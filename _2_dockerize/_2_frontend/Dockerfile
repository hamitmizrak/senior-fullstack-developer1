######################################################################
# Image Create
# docker image build -t customize_nginx .

# Container Create
# docker container run -d -p 1111:80 --rm --name  customize_nginx

# Daocker Registery Create
# Step-1: Dockerfile ile image oluştur => docker image build -t customize_nginx .
# Step-2: DockerHub git public veya private repository oluştur.
# Step-3: docker ps
# Step-4: image Name: customize_nginx
# Step-5: docker image tag imageName javahamitmizrak/oluşturulmuşRepositoryAdi
# Step-5: docker image tag customize_nginx javahamitmizrak/oluşturulmuşRepositoryAdi
# Step-6: docker push javahamitmizrak/oluşturulmuşRepositoryAdi

# ÖNEMLİ NOT: eğer windows üzerinden çalıştırıyorsanız sudo tanımayacaktır.
# ÖNEMLİ NOT: nginx eğer browserda istediğiniz sonuç çıkmazsa browserin cache belleğini temizleyiniz. yoksa nginx'in kendi sayfasını görürüsünüz.

######################################################################
# Multi-Stage Build
# @@@@@@@@@@@

# Node.js tabanlı bir imaj kullanmalıyız.
# Dikkatttt : Örneğin node:14 kullanma bu proje için hata alırsın
FROM node:16

#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# Maintainer
LABEL maintainer="hamitmizrak@gmail.com"

# Ortam Değişkenleri
ENV AUTHOR="Hamit Mızrak"
ENV APP_NAME="Offline Node.js"
ENV TECH="Docker"
ENV VERSION="v1.0.0"
ENV YEAR="2024"
ENV NODE_HOST=localhost
ENV NODE_PORT=1111

# Ortam Değişkeni Çalıştırması
RUN echo "Yazar: $AUTHOR"
RUN echo "Uygulama Adı: $APP_NAME Yılı: $YEAR"
RUN echo "Teknolojiler: $TECH"
RUN echo "Version: $VERSION"
RUN echo "Version: $VERSION"
RUN echo "URL: http//$NODE_HOST:$NODE_PORT"

#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# Dizin Oluştur
# WORKDIR /usr/src/app
# RUN mkdir -p html

# Uygulama dizinini oluştur
WORKDIR /usr/src/app

# Log Veri Sakla
VOLUME ["/var/log/node"]

#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# COPY Local File => Nodejs System File
# package.json ve package-lock.json dosyalarını kopyala
COPY package*.json ./


#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# COPY Local File => Nodejs System File
# nginx dosyalarını kopyala
COPY nginx_data/nginx/nginx.conf /etc/nginx/nginx.conf

# step-2 default.conf
COPY nginx_data/nginx/conf.d/default.conf /etc/nginx/conf.d/default.conf

# step-3 html
# COPY nginx_data/html/   /usr/share/nginx/html
# views/index.ejs eklemek
COPY views/   /usr/share/nginx/html


#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# NPM SSL doğrulamasını devre dışı bırak
RUN npm config set strict-ssl false

# Bağımlılıkları yükle
RUN npm install

# Uygulama kodunu kopyala
COPY . .


#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# Nodejs'in default portu 1111
# Uygulama portunu belirle
EXPOSE 1111

#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# HEALTHCHECK         ==> Bu image dosyasının sağlık durumu (Container Çalışıyor mu)
# --interval=30s      ==> 30 saniyede bir sağlık kontrolü yapılsın
# --timeout=10s       ==>  10 saniyede Sağlık kontrolünü tamamlasın
# --start-periyod=5s  ==> Konteynar başladığında sağlık kontrolünün başlamasın için 5 saniye bekle
# --retries=3         ==>  Sağlık kontrolünü eğer ilk denemede başarısız olursa 3 defa daha  çalışsın.
# Eğer bu 3s komutu belirtilenin dışına çıkarsa Docker sağlıksız olarak işaretlenir
# CMD wget --quiet --tries=1 --spider http://localhost : wget ile localhost istek atmak
HEALTHCHECK --interval=30s --timeout=10s \
    --start-period=5s --retries=3 \
    CMD curl -f http://${NGINX_HOST}:${NGINX_PORT}/ || exit 1
#CMD wget --quiet --tries=1  --spider http://localhost:4444 || exit 1


#@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
# CMD: Konteyner başlatıldığında varsayılan olarak çalışacak komutu söyler.
# Uygulamayı başlat
CMD [ "node", "index.js" ]


##########################################################################
# docker build -t imageName .  => (Defaultta: Dockerfile yazılmışsa)
# docker build -f CustomiseDockerFile -t imageName . => (Dockerfile yerine CustomiseDockerFile yazılmışsa)

# docker ps
# docker ps -a
# docker container ls
# docker container ls -a
# docker image ls
# docker container run -d -p 1111:80 --rm --name nginx_container customize_nginx
# docker container prune
# docker container exec -it containerID bash
# docker container exec -it containerNAME bash
