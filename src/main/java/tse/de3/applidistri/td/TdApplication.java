package tse.de3.applidistri.td;

import lombok.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TdApplication {

    public static void main(String[] args) {
        SpringApplication.run(TdApplication.class, args);
    }

    public String getRole() {
        return "Salut";
    }
}
