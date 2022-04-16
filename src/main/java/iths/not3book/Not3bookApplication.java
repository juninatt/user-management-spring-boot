package iths.not3book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Not3bookApplication {

	public static void main(String[] args) {
		SpringApplication.run(Not3bookApplication.class, args);
	}

	@GetMapping
	public String hi() {
		return "Tjena";
	}
}
