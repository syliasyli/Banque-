package banque.managment.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BackendBanqueApplication {

	public static void main(String[] args) {
		ApplicationContext context = 
				SpringApplication.run(BackendBanqueApplication.class, args);
	}

}
