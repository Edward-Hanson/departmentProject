package com.hanson.department_service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class DepartmentDto {
    UUID id;
    String name;
}
