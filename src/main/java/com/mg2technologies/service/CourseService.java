package com.mg2technologies.service;

import com.mg2technologies.model.Course;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    public List<Course> getCourses() {
        return List.of(
            new Course("DEVOPS-01", "DevOps Engineering",
                "CI/CD, Jenkins, Docker and Kubernetes", "12 weeks", "Online / Classroom"),
            new Course("AZURE-01", "Azure Cloud Engineering",
                "Azure, AKS, networking and monitoring", "10 weeks", "Online / Classroom"),
            new Course("IAC-01", "Terraform Infrastructure as Code",
                "Terraform modules, state and automation", "6 weeks", "Online / Classroom")
        );
    }
}
