package com.hanson.department_service.controller;

import com.hanson.department_service.client.EmployeeClient;
import com.hanson.department_service.model.Department;
import com.hanson.department_service.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
Best practices is overlooked, the purpose of the application is to focus on microservice architecture.
DTOs , DBMS were not used in this project
**/


@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    private final DepartmentRepository departmentRepository;
    private final EmployeeClient employeeClient;

    @PostMapping()
    public Department addDepartment(@RequestBody Department department) {
        LOGGER.info("Adding department {}", department);
        return departmentRepository.addDepartment(department);
    }

    @GetMapping("")
    public List<Department> getAllDepartments() {
        LOGGER.info("Getting all departments");
        return departmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        LOGGER.info("Getting department with id {}", id);
        return departmentRepository.findById(id);
    }

    @GetMapping("/with-employees")
    public List<Department> getAllDepartmentsWithEmployees() {
        LOGGER.info("Getting all departments with employees");
        List<Department> departments = departmentRepository.findAll();
        departments.forEach(department -> department.setEmployees(
                employeeClient.findByDepartment(department.getId())));
        return departments;
    }
}
