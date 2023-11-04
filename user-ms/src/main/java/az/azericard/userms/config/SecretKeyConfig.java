package az.azericard.userms.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

@Configuration
public class SecretKeyConfig {

    @Bean
    public SecretKey passwordEncoder(){
        String secretString = "backend";
        return new SecretKeySpec(secretString.getBytes(), "AES");
    }
}
