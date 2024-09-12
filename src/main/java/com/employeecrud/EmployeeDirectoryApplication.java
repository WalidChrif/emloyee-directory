package com.employeecrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeDirectoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeDirectoryApplication.class, args);
        System.out.println("CLIENT_ID: " + System.getProperty("CLIENT_ID"));
        System.out.println("DB_USERNAME: " + System.getProperty("DB_USERNAME"));
        System.out.println("DB_PASSWORD: " + System.getProperty("DB_PASSWORD"));

    }

}
