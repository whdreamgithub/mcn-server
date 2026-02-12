package mcnumber.vercel.app.mcnserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
public class McnServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(McnServerApplication.class, args);
    }

}
