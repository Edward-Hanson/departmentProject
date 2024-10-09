package com.hanson.department_service.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hanson.department_service.dto.CreateDepartmentRequest;
import com.hanson.department_service.dto.DepartmentDto;
import com.hanson.department_service.dto.GenericResponse;
import com.hanson.department_service.model.Department;
import com.hanson.department_service.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ObjectMapper objectMapper;

    @Override
    public DepartmentDto findDepartmentById(UUID id) {
        return departmentRepository.findById(id).map(object -> objectMapper.convertValue(object, DepartmentDto.class))
                .orElse(null);
    }

    @Override
    public GenericResponse saveDepartment(CreateDepartmentRequest department) {
        GenericResponse genericResponse = new GenericResponse();
        try{
            departmentRepository.save(objectMapper.convertValue(department, Department.class));
            genericResponse.setMessage("Success");
            genericResponse.setCode(201);
        }
        catch(Exception e){
            genericResponse.setMessage(e.getMessage());
            genericResponse.setCode(500);
        }
        return genericResponse;
    }
}
