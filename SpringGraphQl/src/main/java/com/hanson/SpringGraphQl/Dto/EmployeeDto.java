package com.hanson.SpringGraphQl.Dto;

import java.util.UUID;

public record EmployeeDto(String id, String departmentId, String employeeName, String employeePosition,
                          Integer employeeAge) {
}
