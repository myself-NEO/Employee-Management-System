package com.example.demo.dto;

import com.example.demo.models.Address;
import com.example.demo.models.Department;
import com.example.demo.models.Employee;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
public class CreateEmployeeRequest {

    @NotBlank
    private String name;
    @Min(18)
    @Max(60)
    private int age;
    @NotNull
    private Department department;

    private Address address;


    public Employee to() {
        Employee employee = Employee.builder()
                .name(this.name)
                .age(this.age)
                .address(this.address)
                .department(this.department)
                .createdOn(System.currentTimeMillis())
                .updatedOn(System.currentTimeMillis())
                .id(UUID.randomUUID().toString())
                .build();

        return employee;
    }
}
