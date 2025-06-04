package com.dpt.demo;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyWebAppApplication.class, args);

        // Load environment variables from .env file
        Dotenv dotenv = Dotenv.configure()
                              .filename(".env") // optional, defaults to ".env"
                              .ignoreIfMissing() // avoid exception if file is missing
                              .load();

        // Get environment variables
        String sonarToken = dotenv.get("SONAR_TOKEN");
        String jfrogUser = dotenv.get("JFROG_USER");

        // Check and print values
        System.out.println("Sonar Token: " + (sonarToken != null ? sonarToken : "Not Found"));
        System.out.println("JFrog User: " + (jfrogUser != null ? jfrogUser : "Not Found"));
    }
}
