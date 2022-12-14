package configserver.cs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CsApplication {

    public static void main(final String[] args) {
        SpringApplication.run(CsApplication.class, args);
    }

}
