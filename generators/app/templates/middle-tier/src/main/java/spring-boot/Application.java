package <%= packageName %>;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class <%= mainClassName %> {

    public static void main(String[] args) {
        SpringApplication.run(<%= mainClassName %>.class, args);
    }

}
