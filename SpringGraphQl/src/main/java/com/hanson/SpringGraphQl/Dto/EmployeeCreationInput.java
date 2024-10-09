package com.hanson.SpringGraphQl.Dto;

import java.util.UUID;

public record EmployeeCreationInput(String departmentId, String employeeName,
                                    String employeePosition, Integer employeeAge) {
}
