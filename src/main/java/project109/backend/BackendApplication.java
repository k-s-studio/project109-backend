package project109.backend;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
//@ApplicationPath("api")
public class BackendApplication extends Application {

	String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
	public static void main(String[] args) {
		//System.setProperty("server.servlet.context-path", "/api");
		SpringApplication.run(BackendApplication.class, args);
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "mdfk") String name) {
		return String.format("Hello %s, I've been working since %s.", name, timestamp);
	}

	@GetMapping("/")
	public String root() {
		return "Here is root of the project.";
	}
}
