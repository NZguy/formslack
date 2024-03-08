# formslack
app properties
#spring.datasource.url=jdbc:postgresql://localhost:5432/Formslack
spring.datasource.url=jdbc:postgresql://formslack-postgres.cbmk08ii4qfq.us-west-2.rds.amazonaws.com:5432/Formslack
spring.datasource.username=postgres
#spring.datasource.password=admin
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=none
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

docker commands
docker build --build-arg JAR_FILE=build/libs/*.jar -t duncanandrew/formslack .
docker run -p 8080:8080 duncanandrew/formslack
docker exec duncanandrew/formslack /bin/sh

AWS
ssh -i formslackapi.pem ec2-user@<public-ip>

