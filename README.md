# Problem

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar
spent between $50 and $100 in each transaction.
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).

# Application
Application is developed on Spring boot to implement REST architecture and REST services. 

Application uses Hibernate ORM to perform all DB operations.

Application is based on SOLID and YAGNI principals. 

Application implements Layered architecture.

### Security
Application is secured by https protocol.

Application implements web security also which only allows URI starting with "/rewards"

### Exception Handling
Generic exception handler is provided to handle any exception, which suggests to contact Admin.

While exception handling it demonstrates the capability to send custom http status and message.

### Database
Created a local database using H2 which will be initialized by loading sample purchases.

Database design is flat.

### Configuration
Admin may configure the duration for which it wants rewards points.

Admin may configure the default point and points for purchase limits.

Admin may configure the default amount for purchase limit.

Following are configuration parameters

rewards:

  point:
  
    default-point: 0
    
    first-limit: 1
    
    second-limit: 2
    
    duration: -3
    
  price:
  
    first-lower-limit: 50
    
    first-upper-limit: 100
    
    second-lower-limit: 100
    

### Retailer Rewards End Points:

* [Get Monthly Summary per User - https://localhost/rewards/monthly-for-quater](https://localhost/rewards/monthly-for-quater)

* [Get Total Summary per User - https://localhost/rewards/quatrely](https://localhost/rewards/quatrely)

### Testing Layer
The core logic is to test the logic behind rewards calculation which is covered in testing folder.

Command to test at root directory: `mvn test`

### Logging
SLF4J with Log4j2 is used to log statements.

### Start the Project
The entire application is backed by Spring boot which provides the MVC framework for us to start 
and test the application to test right away with inbuilt Tomcat, please execute the below to start 
the application and check the above URL's to verify the application.

Command to build at root directory: `mvn clean install`

Command to run at root directory: `mvn spring-boot:run`

