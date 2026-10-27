package com.mg2technologies.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/api/v1/home")
    public Map<String, Object> home() {
        return Map.of(
            "company", "MG2 Technologies",
            "message", "Empowering careers through technology",
            "services", new String[] {"DevOps Training", "Azure Cloud", "AWS",
                "Kubernetes", "Terraform", "Corporate Training"},
            "website", "https://mg2technologies.com"
        );
    }
}
