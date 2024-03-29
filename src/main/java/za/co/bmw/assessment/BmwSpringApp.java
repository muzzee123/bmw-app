package za.co.bmw.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class BmwSpringApp {

    public static void main(String[] args) {
        SpringApplication.run(BmwSpringApp.class, args);
    }

}
