package log4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import log4j.service.LogExampleService;

import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class MainApplication implements CommandLineRunner {
    @Autowired
    private LogExampleService logExampleService;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Override
    public void run(String... args) {
        logExampleService.execute();
    }
}
