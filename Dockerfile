# ---------- Build stage ----------
FROM maven:3.9-eclipse-temurin-17 AS builder
WORKDIR /build

# Copy file cấu hình trước để cache dependency
COPY pom.xml .
# (nếu có wrapper/config)
COPY .mvn .mvn
COPY mvnw .
RUN mvn -q -B -DskipTests dependency:go-offline

# Copy source và build JAR
COPY src ./src
RUN mvn -q -B -DskipTests clean package

# ---------- Runtime stage ----------
FROM eclipse-temurin:17-jre
WORKDIR /app

# Tạo user không phải root
RUN useradd -ms /bin/bash appuser
USER appuser

# Copy JAR đã build từ stage builder
COPY --from=builder /build/target/*.jar app.jar

# Cổng mặc định Spring Boot
EXPOSE 8080

# Tuỳ chọn health/timezone (không bắt buộc)
ENV TZ=UTC

ENTRYPOINT ["java","-jar","/app/app.jar"]
