package az.azericard.productms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class ProductMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMsApplication.class, args);
	}

}
