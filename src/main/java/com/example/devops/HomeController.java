package com.example.devops;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return """
                =================================
                       DEVOPS TRAINING APP
                =================================

                Application: Online Shopping
                Environment: Production

                Version: 1.0

                Deployed using:
                GitHub
                Jenkins
                Maven
                Docker
                Ansible
                AWS EC2
                """;
    }
}
