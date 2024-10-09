package com.hanson.department_service.controller;

import com.hanson.department_service.dto.CreateDepartmentRequest;
import com.hanson.department_service.dto.DepartmentDto;
import com.hanson.department_service.dto.GenericResponse;
import com.hanson.department_service.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

/*
Best practices is overlooked, the purpose of the application is to focus on microservice architecture.
**/


@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
    private final DepartmentService departmentService;


    @GetMapping("/{id}")
    public DepartmentDto getDepartmentById(@PathVariable UUID id) {
        LOGGER.info("Getting department with id {}", id);
        return departmentService.findDepartmentById(id);
    }

    @PostMapping
    public GenericResponse createDepartment(@RequestBody CreateDepartmentRequest department) {
        return departmentService.saveDepartment(department);
    }
}
