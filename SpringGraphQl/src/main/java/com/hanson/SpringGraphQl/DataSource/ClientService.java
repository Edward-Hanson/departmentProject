package com.hanson.SpringGraphQl.DataSource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanson.SpringGraphQl.Dto.DepartmentCreationInput;
import com.hanson.SpringGraphQl.Dto.DepartmentDto;
import com.hanson.SpringGraphQl.Dto.DepartmentResponseDto;
import com.hanson.SpringGraphQl.Dto.EmployeeCreationInput;
import com.hanson.SpringGraphQl.Dto.EmployeeDto;
import com.hanson.SpringGraphQl.Dto.GenericResponse;
import com.hanson.SpringGraphQl.Exception.GenericGraphQLException;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.IOException;
import java.util.List;

@Service
public class ClientService {

    private final ObjectMapper mapper = new ObjectMapper();

    private final RestClient employeeClient = RestClient.builder()
            .baseUrl("http://localhost:8000/employee")
            .build();

    private final RestClient departmentClient = RestClient.builder()
            .baseUrl("http://localhost:8001/department").build();




    public void saveEmployee(EmployeeCreationInput input){
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(input);
        employeeClient.post()
                .uri("")
                .body(input)
                .retrieve();
    }


    public List<EmployeeDto> getEmployees() throws IOException {
        JsonNode employees = employeeClient.get()
                .uri("")
                .retrieve()
                .body(JsonNode.class);

        return mapper.convertValue(employees, new TypeReference<List<EmployeeDto>>() {
        });
    }


    public EmployeeDto getEmployeeById(String id) {
        return employeeClient.get()
                .uri("/{id}",id)
                .retrieve()
                .body(EmployeeDto.class);
    }


    public DepartmentDto getDepartment(String id) {
        DepartmentDto department;
        DepartmentResponseDto departmentResponse;
        try {
           departmentResponse = departmentClient.get()
                    .uri("/{id}", id)
                    .retrieve()
                    .body(DepartmentResponseDto.class);

        }
        catch (Exception e) {
            throw new GenericGraphQLException(e.getMessage());
        }
        department = mapper.convertValue(departmentResponse, DepartmentDto.class);
        department.setEmployees(employeesPerDepartment(departmentResponse));

        return department;
    }


    @Async
    protected List<EmployeeDto> employeesPerDepartment(DepartmentResponseDto department) {
        try {
            JsonNode employeeNode = employeeClient.get()
                    .uri("/department/{id}", department.getId())
                    .retrieve()
                    .body(JsonNode.class);
            return mapper.convertValue(employeeNode, new TypeReference<List<EmployeeDto>>() {
            });
        }
        catch (Exception e) {
            throw new GenericGraphQLException(e.getMessage());
        }
    }


    public GenericResponse createDepartment(DepartmentCreationInput input) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(input);
        try{
            return departmentClient.post()
                    .uri("")
                    .body(mappingJacksonValue)
                    .retrieve()
                    .body(GenericResponse.class);
        }
        catch (Exception e) {
            throw new GenericGraphQLException(e.getMessage());
        }
    }
}

