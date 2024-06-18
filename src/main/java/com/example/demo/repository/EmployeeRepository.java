package com.example.demo.repository;

import com.example.demo.models.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    private final HashMap<String, Employee> employeeHashMap = new HashMap<>();

    public Employee create(Employee employee) {
        employeeHashMap.put(employee.getId(), employee);
        return employee;
    }

    public Employee getById(String id) {
        return employeeHashMap.getOrDefault(id, null);
    }

    public List<Employee> getAllEmployees() {
        return employeeHashMap.values().stream().collect(Collectors.toList());
    }
}
