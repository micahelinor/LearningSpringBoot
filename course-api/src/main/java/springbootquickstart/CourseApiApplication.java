package springbootquickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController		// to make any class a rest controller
public class CourseApiApplication {

	public static void main(String[] args) {
		//set up default configuration
		//starts spring application context
		//perform class path scan
		//starts Tomcat server
		SpringApplication.run(CourseApiApplication.class, args);	// a way to run the springboot application
	}

	/*@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "Charlie") String name) {
		return String.format("Hello %s!", name);
	}*/
}