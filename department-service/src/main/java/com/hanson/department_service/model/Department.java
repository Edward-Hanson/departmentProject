package com.hanson.department_service.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Department {

    public Department(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    private Long id;
    private String name;
    private  List<Employee> employees = new ArrayList<>();

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }
}
