dropwizard-jdbi-rest
========================

Project template for a REST service exposed through dropwizard and backed by an embedded MYSQL accessed through JDBI.

This contains,

- Dropwizard application exposing REST server
- UserDAO which uses JDBI to interact with database
- Embedded Mysql integration
- Sample test creditcard

which works together out-of-the-box.

Usage
=====

To start the server,

- create the distributable by running "mvn clean install"
- move to target folder and run "java -jar dropwizard-jdbi-rest-1.0-SNAPSHOT.jar server ../myapp.yaml"

The server will start at port 8080. You can use CreditCardResourceClient to interact with it. You can also get into admin interface by going to http://localhost:8081

In browser: localhost:8080/creditcard/locale/pt-PT


