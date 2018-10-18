package pt.isel.ngspipes.share_repository_facade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);



    public static void main(String[] args) {
        LOGGER.info("::STARTING::");

        SpringApplication.run(App.class, args);

        LOGGER.info("::RUNNING::");
    }

}
