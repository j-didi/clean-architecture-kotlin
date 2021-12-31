FROM alpine:3.15.0
RUN apk update && apk add openjdk17
RUN mkdir /app/
WORKDIR /app/
COPY build/libs/api-1.0-SNAPSHOT-all.jar .
CMD ["java", "-jar", "api-1.0-SNAPSHOT-all.jar"]