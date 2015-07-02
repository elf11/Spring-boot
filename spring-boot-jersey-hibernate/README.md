RESTfull web services with Spring Boot, Jersey and hibernate using PostgreSQL database (Java configuration)

Technologies:
Java 8
Maven 3
Spring Boot 1.1.9.RELEASE
Jersey 2.7
Hibernate 4
PostgreSQL

JSON-to-Java binding done using Jackson


Structure:

com.jersey: Application.java = main class for set-up Spring Boot and inject all the Jersey resources into servlet

com.jersey.config:  JerseyInitialization.java = class which inherits resource configuration class which is main class for configuring a web application and add all resources under resources package
		    SqlInitialization.java = class to initialize the data connection !!!!!! -> UPDATE! dataSource() method with your username and password for the data base (annotation "EnableJpaRepository" scans for all spring data repositories under the given package)
		    ObjectMapperFactory.java = Jackson handles all primitive data types, but it crashes when it must handle nested objects (like a Dashboard with a widget inside), so I here I am using Hibernate 4 modules wich are handled by Jackson JSON processor. 

com.jersey.persistance: files that initiate the Spring Data JPA (Java Persistance API)

com.jersey.representations: files that represent that tables in the data base (entities) - the classes are annotated "@Entity"  which indicates that it is a JPA entity

com.jersey.resources: files where the RESTful services are exposed 

Note: @Component and @Transactional annotations are needed for poking lazy loading objects (the widgets for the dashboard and the reports for the widgets -  when we want to get widgets for a dashboard, which are lazy loaded, we would like to have transaction session opened while all widgets are fetched from database. Without those annotations hibernate will close connection before transaction is finished and you will end up with LazyInitializationException.)

Testing:

To test, first execute SQL query located at resources folder(src/main/resources/db.sql) against "demo" (you can create your own data base and name it whatever you want, just remember to update the name in SqlInitialization class) database and populate with some data.
Update credentials in SqlInitialization class

dataSource.setUsername("your-username");
dataSource.setPassword("your-password");

Building:
mvn package clean
mvn package
java -jar target/spring-boot-jersey-hibernate-1.0-SNAPSHOT.jar

Go to: localhost:8080/api/dashboards

Services implementated (those from the initial conversation but some others too):

/api/widgets - GET - Return all widgets
/api/widgets - POST - Create new widget
/api/widgets/:widget_id - GET - Return single widget
/api/widgets/:widget_id - PUT - Update existing widget
/api/widgets/:widget_id - DELETE - Delete widget
/api/dashboards - GET - Return all dashboards
/api/dashboards - POST - Create new dashboard
/api/dashboards/:dashboard_id - GET - Return single dashboard
/api/dashboards/:dashboard_id - PUT - Update existing dashboard
/api/dashboards/:dashboard_id - DELETE - Delete dashboard
/api/reports - GET - Return all reports
/api/reports - POST - Create new report
/api/reports/:report_id - GET - Return single report
/api/reports/:report_id - PUT - Update existing report
/api/reports/:report_id - DELETE - Delete report
/api/settings - GET - Return all settings
/api/settings/{id} - PUT - Update settings with id
/api/settings/{id} - DELETE - delete settings with id
/api/login - Login user (dummy service)
/api/logout- Logout user (dummy service)

/api/dashboards/:dashboard_id/widgets - GET - get all the widgets for dashboard with id dashboard_id
/api/widgets/:widget_id/reports - GET - get all the reports for widget with widget id widget_id
