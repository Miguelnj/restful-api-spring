# restful-api-spring
This is a API developed using Spring, integrated with Spring Security. 
This API consists of 2 main entities, Customers and Users. First ones are those whose information is registered in the 
platform but cannot access the API. Last ones are users that have a username, a password and can have diferent roles. 

## Installation and Getting Started
This is a Spring Boot application, containing all the dependencies in a pom.xml file(Maven project). This means that the API can work as a standalone .jar application or a .war file can be generated to be traditionaly deployed.
To download this project just clone it into intelliJ Idea, wait for the dependencies to be imported and run it.

## Running the application

The main class of all this project is:

```java
@SpringBootApplication
  public class ProjectApplication {
      public static void main(String[] args) {
          SpringApplication.run(ProjectApplication.class, args);
      }
  }
```
When you run the project by this start point, the entire API start to work.

## The Database
The database used for this API is an embedded "h2" database. This is the one used for reasons of availability. To change the database used you just need to change some lines in the **application.properties** file found in the resources package of the project.
The database is initialized with a minimum data, which consists in 2 customers and 1 user with both Admin and User roles.
To initialize the "h2" database with some data, queries must be writen in a file named "data-h2.sql" found in the resources package of the project, which looks like:
```sql
INSERT INTO user VALUES(1,'$2a$04$2/y1i84w03REpz.t1nTaYeFsgwaK7FnYnEwdEVLX79cQjHvOglg4u','username')
INSERT INTO customer VALUES(1,'user1',null,'Miguel','http://localhost:8080/resources/images/imagesPhotoPerson1','Pérez')
INSERT INTO customer VALUES(2,'user1',null,'Alberto','http://localhost:8080/resources/images/imagesPhotoPerson2','Rodríguez')
INSERT INTO roles VALUES(1,'ROLE_ADMIN')
INSERT INTO roles VALUES(2,'ROLE_USER')
INSERT INTO user_roles VALUES(1,1)
INSERT INTO user_roles VALUES(1,2)
```
**Note:** The password field of the user is "$2a$04$2/y1i84w03REpz.t1nTaYeFsgwaK7FnYnEwdEVLX79cQjHvOglg4u", which is the encoded password **pass123**

## The API
As mentioned above, this API consists of Customers and Users. Only the last ones can use the API, because it is protected with username and password. By default, there is a user created with the "admin" role:
- **Username:** username
- **Password:** pass123
