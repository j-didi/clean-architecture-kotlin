FROM alpine:3.15.0
EXPOSE 4495:4495
RUN apk update && apk add openjdk17
RUN mkdir /app/
WORKDIR /app/
COPY build/libs/notifier-1.5-all.jar .
CMD ["java", "-jar", "notifier-1.5-all.jar"]