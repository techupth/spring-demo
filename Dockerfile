# ---------- Build stage ----------
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app

# ใส่ pom ก่อนเพื่อ cache dependencies
COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline

# ค่อยก็อป src ทีหลัง เพื่อลด cache bust
COPY src ./src
RUN mvn -q -DskipTests package

# ---------- Runtime stage ----------
FROM eclipse-temurin:21-jre
WORKDIR /app

# Render จะส่ง ENV PORT มาให้ (เผื่อรันโลคัล default 8080)
ENV PORT=8080
ENV JAVA_OPTS="-Djava.security.egd=file:/dev/./urandom"

# คัดลอก jar จาก stage แรก (ใช้ชื่อ wildcard ให้ยืดหยุ่น)
COPY --from=build /app/target/*.jar /app/app.jar

# ระบุพอร์ตในคอนเทนเนอร์ (เพื่อความชัดเจน)
EXPOSE 8080

# บังคับ bind 0.0.0.0 และใช้พอร์ตตาม ENV
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app/app.jar --server.port=${PORT} --server.address=0.0.0.0"]