#!/bin/bash
echo "Spring Boot - Postgres"

# mvn clean package
# mvn clean package -DskipTests

docker-compose -f postgres_docker-compose.yml up -d