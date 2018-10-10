# SpringBootRestAPI Project

This is a basic spring boot web project required for beginners.
This spring-boot application is basic implementation of what you can do with SPRING.

## Prerequsites

Prior having a look at this project one needs to have basic knowledge of spring, RESTful API's, java, hibernate and POJO.

### Features

This project has implementation of below features:
* Spring-boot
* RESTful API
* H2-JPA Implementation
* SSL Implementation
* Basic Authentication or Spring Security

### Required Tools
* Java 1.8+
* Apache Maven
* Spring tool suite

### Installation
* Clone the repository.
* Import project into STS workspace as MAVEN project.
* Right click on the project -> Run -> **Spring boot app**
* Use Postman to hit APIs

### Future Enhancement
* Adding Swagger for documentation.
* Logging Mechanism
* JWT Implementation
* Exception Handling

### Description

This is a very basic project having employees of an organization with different roles. Anyone can view the list of employees but only user with proper role is able to add new employee to the organization. We can also view the employee details with his/her perticular employee id.    
From abvove it is clear that we have atleast **3 rest end points**, one with all the employees details, single employee details and last one adding  new employees. We have secured the last end point with basic authentication and rest of the 2 are open to all.  
RESTful web service have a controller `EmployeeController` which is mapped to the URI's and this controller uses a service `EmployeeController` to perform CRUD operations. CRUD operations are performed via `EmployeeRepo` interface using model of `Employee` and `Roles` as Entity.  


### Folder/Package Structure
1. Controller
2. Service
3. Repository/DAO
4. Model
5. Configuration	
