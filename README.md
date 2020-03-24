## Dentist application 

### Application running
* Download and import application to IDE
* Run DentistAppApplication.java file
* When app is running (Started DentistAppApplication in console) go to http://localhost:8080/

### Stage 1
#### 1A and 1B
10 min. First look at the web application structure. The application architecture seems familiar to me. While looking at the pom.xml file I realized that Spring Boot project uses the H2 database and Thymeleaf for UI.

#### 1C
2 hours. Started with Thymeleaf. I’ve never worked with this tool before but a few months ago I took a udemy Spring/Hibernate course what was updated with Thymeleaf topic for now. Just a couple videos/source code and I’ve Implemented dropdown menu, date text field was replaced to «datetime-local» - now user can choose date and time in a single place. While applying Bootstrap styles I realized that table layout is not the best for user experience, so I recreated form.html page from zero.

Stucked on validation with «datetime-local». After some searching, I’ve found an almost needed pattern on StackOverflow. Some modifications and validation are working fine.

### Stage 2
4 hours. Updated DentistVisitEntity class to be possible to get data from UI, also checked if I can access the database from browser and table with columns are existing. Old java.util.Date was changed to Java 8 Date/Time API. Some message properties were updated as well. Not going to use a data transfer object because DentistVisitDTO and DentistVisitEntity are the same now. I realized that the DAO/Repository package is missing in the project structure and added it.

Created registration.html file. This stage seems easy. I’ve done CRUD web applications a few times before, so nothing new here.

During this stage, all needed CRUD methods and database queries (Spring Data JPA already has most of them) for repository and service layers were implemented. During the next stages, I only need to test them and maybe modify.

Spring Data JPA is used for communication with the H2 database. Updated Spring Boot version to 2.2.2 (1.5.1 was before). Deprecated WebMvcConfigurerAdapter changed to WebMvcConfigurer.
### Stage 3
3 hours. Searching implementation wasn’t too hard. I’ve read Bootstrap documentation to make frontend search field user friendly. The search function for the backend wasn’t too hard also. I've implemented searching by dentist name. Much time takes manual testing of the web application.

The last part of the 3rd stage was probably the hardest part of the project because I’ve never done it before. Not too much code here but overall conception is new for me. Thymeleaf documentation reading not made clear how to implement click function on the table row. As always I’ve found the solution on StackOverflow. JavaScript enters the game and this functional requirement is done also.

### Stage 4
#### 4A and 4B
1 hour. 4th A stage was made after 2nd because it seems easier for me and all registration table columns are implemented before. So I need only add appropriate controllers and functions to the delete and update buttons.

For the update function, I used the same view.html page as for visit creation to make the project more simple and avoid boilerplate code.

### Additional information
* All functional and non-functional requirements are implemented
* Thymeleaf is the most challenging part of the project
* Web application manual testing for bugs is taking really much time. Sometimes 〜 20-30% of overall implementation time
* Project code has links to solutions (e.g. StackOverflow) in some places
* Project code has comments if the author considers it necessary
