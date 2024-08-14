package com.hanson.employee_service.repository;

import com.hanson.employee_service.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<Employee>();

    public Employee addEmployee(Employee employee) {
        employees.add(employee);
        return employee;
    }

    public Employee getEmployee(Long id) {
        return employees.stream().filter(employee -> employee.id().equals(id)).findFirst().orElseThrow();
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public List<Employee> getEmployeeByDepartmentId(Long departmentId) {
        return employees.stream().filter(employee -> employee.departmentId().equals(departmentId)).toList();
    }
}
