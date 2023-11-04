package az.azericard.cardms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class CardMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardMsApplication.class, args);
	}

}
