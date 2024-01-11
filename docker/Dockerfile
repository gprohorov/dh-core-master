FROM bellsoft/liberica-openjdk-alpine:8

RUN apk add curl

RUN addgroup -S clinicway && adduser -S clinicway -G clinicway
USER clinicway:clinicway

WORKDIR /usr/app
COPY ./target/boot/*.jar application.jar

CMD java $JAVA_OPTIONS -jar application.jar