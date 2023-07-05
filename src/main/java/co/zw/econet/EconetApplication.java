package co.zw.econet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class EconetApplication {

	public static void main(String[] args) {
		SpringApplication.run(EconetApplication.class, args);
	}

}
