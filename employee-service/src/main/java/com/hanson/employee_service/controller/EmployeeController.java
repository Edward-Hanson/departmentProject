package com.hanson.employee_service.controller;

import com.hanson.employee_service.dto.EmployeeDto;
import com.hanson.employee_service.model.Employee;
import com.hanson.employee_service.service.EmployService;
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
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployService employeeService;

    @PostMapping
    public void createEmployee(@RequestBody Employee employee) {
        LOGGER.info("Creating employee : {}", employee);
        employeeService.save(employee);
    }

    @GetMapping
    public List<EmployeeDto> getAllEmployees() {
        LOGGER.info("Getting all employees");
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Optional<EmployeeDto> getEmployee(@PathVariable UUID id) {
        LOGGER.info("Getting employee : {}", id);
        return employeeService.findEmployeeById(id);
    }

    @GetMapping("/department/{id}")
    public List<EmployeeDto> getEmployeeByDepartment(@PathVariable UUID id) {
        return employeeService.findEmployeesByDepartmentId(id);
    }
}
