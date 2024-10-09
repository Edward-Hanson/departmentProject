package com.hanson.SpringGraphQl.Service;

import com.hanson.SpringGraphQl.DataSource.ClientService;
import com.hanson.SpringGraphQl.Dto.DepartmentCreationInput;
import com.hanson.SpringGraphQl.Dto.DepartmentDto;
import com.hanson.SpringGraphQl.Dto.EmployeeCreationInput;
import com.hanson.SpringGraphQl.Dto.EmployeeDto;
import com.hanson.SpringGraphQl.Dto.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final ClientService clientService;

    @Override
    public GenericResponse createEmployee(EmployeeCreationInput input) {
        GenericResponse response = new GenericResponse();
        try {
            clientService.saveEmployee(input);
            response.setMessage("Employee created successfully");
            response.setCode(201);
        } catch (Exception e) {
            response.setMessage(e.getMessage());
            response.setCode(500);
        }
        return response;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() throws IOException {
        try {
            return clientService.getEmployees();
        } catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override
    public EmployeeDto getEmployById(String id) {
        try {
            return clientService.getEmployeeById(id);
        } catch (Exception e) {
            throw new RuntimeException("Can not fetch employ: " + e.getMessage());
        }
    }

    @Override
    public DepartmentDto getDepartment(String id) {
        return clientService.getDepartment(id);
    }

    @Override
    public GenericResponse createDepartment(DepartmentCreationInput input) {
        return clientService.createDepartment(input);
    }
}
