DateTime Web and Swing Application

This project is a Java-based REST API with a Java Swing desktop application that fetches the current date and time. 

Project Structure

src/enactorjws/resource/

CorsFilter.java - CORS support to enable access for Swagger Editor<br>
DateTimeResource.java - REST API for date and time with string and JSON responses<br>
DateTimeSwingApp.java - Java Swing application with JFORM and JLABEL for retrieving date and time<br>
HelloWorldResource.java - HelloWorld REST API for experimentation and development of solution<br>

docs/

swagger.yaml - Swagger 2.0 API definition

WebContent/META-INF/WEB-INF/

web.xml - Deployment descriptor with servlet container and mapping for URLs<br>
index.html - Hello world page for testing server access

pom.xml -  Maven configuration with dependencies<br>

README.md                           

How to Run

REST API

Start the Tomcat server

Access the following URL in a browser: <br>

http://localhost:8080/enactorjws/index.html to confirm the server is running

Access the following endpoints in your browser or via Postman:<br>

http://localhost:8080/enactorjws/api/datetime/string (Plain text response)<br>
http://localhost:8080/enactorjws/api/datetime/json (JSON response)

Swing Application

Run the DateTimeSwingApp class from Eclipse:<br>
Open the file in Eclipse, right-click, and select Run As > Java Application.<br>
The Swing UI will display a button to fetch the date and time from the REST API.

Swagger API Documentation

The REST API is documented using Swagger 2.0.<br>
Import it into Swagger Editor for interactive documentation.


