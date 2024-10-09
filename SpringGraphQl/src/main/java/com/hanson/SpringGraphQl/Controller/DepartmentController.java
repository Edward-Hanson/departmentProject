package com.hanson.SpringGraphQl.Controller;


import com.hanson.SpringGraphQl.Dto.DepartmentCreationInput;
import com.hanson.SpringGraphQl.Dto.DepartmentDto;
import com.hanson.SpringGraphQl.Dto.EmployeeCreationInput;
import com.hanson.SpringGraphQl.Dto.EmployeeDto;
import com.hanson.SpringGraphQl.Dto.GenericResponse;
import com.hanson.SpringGraphQl.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DepartmentController {

    private final EmployeeService employeeService;


  @QueryMapping
    public String hello(){
      return "Hello World";
  }

  @MutationMapping
    public GenericResponse createEmployee(@Argument EmployeeCreationInput input){
     return employeeService.createEmployee(input);
  }

  @QueryMapping
    public List<EmployeeDto> getAllEmployees() throws IllegalAccessException, IOException {
     return employeeService.getAllEmployees();
  }

  @QueryMapping
    public EmployeeDto getEmployee(@Argument String id) {
      return employeeService.getEmployById(id);
  }

  @QueryMapping
  public DepartmentDto getDepartment(@Argument String id) {
    return employeeService.getDepartment(id);
  }

  @MutationMapping
  public GenericResponse createDepartment(@Argument DepartmentCreationInput input){
    return employeeService.createDepartment(input);
  }

}
