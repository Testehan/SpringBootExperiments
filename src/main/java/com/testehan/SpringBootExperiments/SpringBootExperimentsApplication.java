package com.testehan.SpringBootExperiments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// you can run this to start the app. Or you can go to the Terminal tab and run
// "java -jar SpringBootExperiments-0.0.1-SNAPSHOT.jar" ...if you want to start the app on a different port you can run
// "java -jar SpringBootExperiments-0.0.1-SNAPSHOT.jar --server.port=8081"
// Then head out to http://localhost:8080/api/v1/student to see the students
// that are configured to be inserted in the DB in class StudentConfiguration.
// In postman, you have in the SpringBoot folder post, delete and put request that you can send to alter studends in DB
@SpringBootApplication
public class SpringBootExperimentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExperimentsApplication.class, args);
	}


}
