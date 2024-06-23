package com.example.demo.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Employee {

    private String id;
    private String name;
    private int age;
    private Department department;
    private Address address;
    private Long createdOn;
    private Long updatedOn;
}
