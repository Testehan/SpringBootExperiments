package com.testehan.SpringBootExperiments;

import com.testehan.SpringBootExperiments.alien.Alien;
import com.testehan.SpringBootExperiments.docs.lookup.SchoolService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


// you can run this to start the app. Or you can go to the Terminal tab and run
// "java -jar SpringBootExperiments-0.0.1-SNAPSHOT.jar" ...if you want to start the app on a different port you can run
// "java -jar SpringBootExperiments-0.0.1-SNAPSHOT.jar --server.port=8081"
// Then head out to http://localhost:8080/api/v1/student to see the students
// that are configured to be inserted in the DB in class StudentConfiguration.
// In postman, you have in the SpringBoot folder post, delete and put request that you can send to alter studends in DB
@SpringBootApplication
public class SpringBootExperimentsApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(SpringBootExperimentsApplication.class, args);

		Alien a1 = context.getBean(Alien.class);
		a1.setName("Thanos");
		a1.show();

		Alien a2 = context.getBean(Alien.class);
		a2.setName("Rocket racoon");
		a2.show();
		a1.show();




		SchoolService first = context.getBean(SchoolService.class);
		SchoolService second = context.getBean(SchoolService.class);

		System.out.println(first.hashCode() + " == " + second.hashCode());
		// Using @Lookup, we can get an instance of SchoolNotification through our singleton bean, every time
		// getNotification() method is called..
		System.out.println(first.getNotification().hashCode() + " != " + second.getNotification().hashCode());
	}


}
