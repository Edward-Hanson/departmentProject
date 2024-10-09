package com.hanson.SpringGraphQl.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentDto {
    private UUID id;
    private String name;
    List<EmployeeDto> employees;
}
