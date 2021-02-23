package com.personalprojects.projectmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ProjectManagementSystemApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(ProjectManagementSystemApplication.class,
            args);
    }

}
