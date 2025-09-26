FROM openjdk:17-jdk-slim
WORKDIR /app
COPY . .
# ví dụ chạy class Main (nếu có); nếu dùng Maven hãy dùng kiểu copy jar
CMD ["bash","-lc","echo 'Dockerfile placeholder for lab' && sleep 5"]
