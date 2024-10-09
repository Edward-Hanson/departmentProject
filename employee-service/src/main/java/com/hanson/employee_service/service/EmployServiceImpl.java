package com.hanson.employee_service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanson.employee_service.dto.EmployeeDto;
import com.hanson.employee_service.model.Employee;
import com.hanson.employee_service.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployServiceImpl implements EmployService {

    private final EmployeeRepository employeeRepository;
    private final ObjectMapper objectMapper;

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(employee -> objectMapper.convertValue(employee, EmployeeDto.class))
                .toList();
    }

    @Override
    public Optional<EmployeeDto> findEmployeeById(UUID id) {
        return employeeRepository.findById(id).map(employee -> objectMapper.convertValue(employee, EmployeeDto.class));
    }

    @Override
    public List<EmployeeDto> findEmployeesByDepartmentId(UUID id) {
        return employeeRepository.findByDepartmentId(id)
                .stream()
                .map(employee -> objectMapper.convertValue(employee, EmployeeDto.class)).toList();
    }
}
