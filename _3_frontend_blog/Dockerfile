# docker image build -t imageAdi .
# docker container run -d -p 3333:80 --rm --name my_imageName

# DockerHub push
# 1.adım: Dockerfile ile image oluştur
# 2.adım: Dockerhub üzerinden repository oluştur
# 3.adım: docker ps
# image name: image_spring_react
# 4.adım: docker image tag image_spring_react javahamitmizrak/fullstack11
# 5.adım: docker push javahamitmizrak/fullstack11

#####################################################################
# FROM:  Çalıştıracağımız image adı
# Node JS Image
FROM node:18.17.1

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

# Directory Create
WORKDIR /app

# RUN: Terminalde çalışmasını istediğimiz kısımlar
# RUN mkdir -p deneme

# Data Persist (Kalıcı Veri)
VOLUME /tmp

# COPY
COPY ["package.json","package-lock.json","./"]

# Running Continue
RUN npm -v
RUN npm -g list

RUN ls
RUN node -v
RUN mvn -v
RUN npm install --production
RUN npm install -g typescript

# Clear Cache
RUN apt-get clean --force && rm -rf /var/lib/apt/lists/*

# COPY
COPY . .

# 1<=PORT<=1023
# 1023<=PORT<=49151
# 49151<=PORT<=65535

# EXPOSE
# 80  = Web dış dünyaya açılış yeridir
# 443 = SSL Sertifates
EXPOSE 80 443

# CMD
CMD ["npm","start"]


# HEALTHCHECK => Bu image dosyasının sağlık durumu (Container Çalışıyor mu)
# --interval=30s  ==> 30 saniyede bir sağlık kontrolü yapılsın
# --timeout=3s  ==>  10 saniyede Sağlık kontrolünü tamamlasın
# --start-periyod=5s  ==> Konteynar başladığında sağlık kontrolünün başlamasın için 5 saniye bekle
# --retries=3  ==>  Sağlık kontrolünü eğer ilk denemede başarısız olursa 3 defa daha  çalışsın.
# Eğer bu 3s komutu belirtilenin dışına çıkarsa Docker sağlıksız olarak işaretlenir
# CMD wget --quiet --tries=1 --spider http://localhost : wget ile localhost istek atmak
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
    CMD wget --quiet --tries=1  --spider http://localhost:4444 || exit 1

# Docker konteynarı çalışması sırasında varsılan çalışacak komutlar
# Uygulamayı başlatma komut dizinidir
# ENTRYPOINT ["executable","param1","param2","param3"]
ENTRYPOINT ["java", "-jar","/blog.jar"]

########################################################
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