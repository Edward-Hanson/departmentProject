package com.hanson.employee_service.controller;

import com.hanson.employee_service.model.Employee;
import com.hanson.employee_service.repository.EmployeeRepository;
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

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeRepository employeeRepository;

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        LOGGER.info("Creating employee : {}", employee);
        return employeeRepository.addEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        LOGGER.info("Getting all employees");
        return employeeRepository.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        LOGGER.info("Getting employee : {}", id);
        return employeeRepository.getEmployee(id);
    }

    @GetMapping("/department/{id}")
    public List<Employee> getEmployeeByDepartment(@PathVariable Long id) {
        LOGGER.info("Getting employee by department : {}", id);
        return employeeRepository.getEmployeeByDepartmentId(id);
    }
}
