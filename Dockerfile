#FROM scratch
FROM ubuntu:20.04
COPY target/app-delta-poc-spring-native /app
ENTRYPOINT ["/app"]
