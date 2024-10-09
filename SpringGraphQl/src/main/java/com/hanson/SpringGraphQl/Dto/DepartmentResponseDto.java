package com.hanson.SpringGraphQl.Dto;

import lombok.Data;

import java.util.UUID;

@Data
public class DepartmentResponseDto {
    UUID id;
    String name;
}
