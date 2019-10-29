package froebera.dadjokes.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DadJokeServiceApplication {

	public static final Logger logger = LoggerFactory.getLogger(DadJokeServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DadJokeServiceApplication.class, args);
		logger.debug("Heyo");
	}
}
