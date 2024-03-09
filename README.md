# formslack
app properties
#spring.datasource.url=jdbc:postgresql://localhost:5432/Formslack
spring.datasource.url=jdbc:postgresql://formslack-postgres.cbmk08ii4qfq.us-west-2.rds.amazonaws.com:5432/Formslack
spring.datasource.username=postgres
#spring.datasource.password=admin
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=none
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect

gradle commands
gradlew build
gradlew bootRun

docker commands
docker build --build-arg JAR_FILE=build/libs/*.jar -t duncanandrew/formslack .
docker run -d -p 8080:8080 duncanandrew/formslack
docker exec -ti duncanandrew/formslack /bin/sh

AWS
ssh -i formslackapi.pem ec2-user@54.187.99.109
sudo usermod -a -G docker ec2-user

Notes:
To deploy without revealing secrets avoid docker hub and build image on ec2 directly with added env passwords from vim
- This doesn't seem to work out of the box, I should adapt to a build pipeline pushing docker images to ACR instead (the correct way)

Key job responsibilities Design and implement Mobile Web Apps and native apps for Communications and Services. Partner with stakeholder engineering teams for cross-team projects Drive web and app development best practices within the team Basic qualifications 4+ years of non-internship professional front end, web or mobile software development using JavaScript, HTML and CSS experience 5+ years of front-end developer creating prototypes or wire-frames for enterprise web applications or workflows experience Experience developing with MVC/MVM frameworks (e.g. React.JS, AngularJS, Vue) Preferred qualifications Knowledge of web services technologies such as SOAP, HTTP, WSDL, XSD, and REST Experience in a broad range of software design approaches and common UX patterns.