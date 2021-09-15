FROM openjdk:11-jre
RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/portfolio-service.jar
WORKDIR /app

# These are hardcoded as env vars but ideally should be injected from a Vault
# or manually set on the running machine
ENV DB_USERNAME=postgres
ENV DB_PASS=1234

ENTRYPOINT java \
  -Dservice.db.url=${DB_URL} \
  -Dservice.db.username=${DB_USERNAME} \
  -Dservice.db.password=${DB_PASS} \
  -jar portfolio-service.jar