# 1단계: 빌드 스테이지
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
COPY . .
RUN chmod +x ./gradlew
RUN ./gradlew bootJar

# 2단계: 실행 스테이지
FROM eclipse-temurin:17-jre
WORKDIR /app

# 빌드된 jar 파일만 복사
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]