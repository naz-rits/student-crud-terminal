package com.example.dsa.dsaproject;

import com.example.dsa.dsaproject.services.StudentService;
import com.example.dsa.dsaproject.services.StudentServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class DsaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DsaProjectApplication.class, args);
    }



}
