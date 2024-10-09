package com.hanson.SpringGraphQl.Service;

import com.hanson.SpringGraphQl.Dto.DepartmentCreationInput;
import com.hanson.SpringGraphQl.Dto.DepartmentDto;
import com.hanson.SpringGraphQl.Dto.EmployeeCreationInput;
import com.hanson.SpringGraphQl.Dto.EmployeeDto;
import com.hanson.SpringGraphQl.Dto.GenericResponse;

import java.io.IOException;
import java.util.List;

public interface EmployeeService {
    GenericResponse createEmployee(EmployeeCreationInput input);
    List<EmployeeDto> getAllEmployees() throws IOException;
    EmployeeDto getEmployById(String id);
    DepartmentDto getDepartment(String id);
    GenericResponse createDepartment(DepartmentCreationInput input);
}
