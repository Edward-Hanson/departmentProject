package com.hanson.department_service.service;

import com.hanson.department_service.dto.CreateDepartmentRequest;
import com.hanson.department_service.dto.DepartmentDto;
import com.hanson.department_service.dto.GenericResponse;

import java.util.UUID;

public interface DepartmentService {
    DepartmentDto findDepartmentById(UUID id);
    GenericResponse saveDepartment(CreateDepartmentRequest department);
}
