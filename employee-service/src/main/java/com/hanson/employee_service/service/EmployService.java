package com.hanson.employee_service.service;

import com.hanson.employee_service.dto.EmployeeDto;
import com.hanson.employee_service.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployService {
    void save(Employee employee);
    List<EmployeeDto> getAllEmployees();
    Optional<EmployeeDto> findEmployeeById(UUID id);
    List<EmployeeDto> findEmployeesByDepartmentId(UUID id);
}
