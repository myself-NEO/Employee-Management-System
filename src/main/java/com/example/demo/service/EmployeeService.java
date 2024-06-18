package com.example.demo.service;

import com.example.demo.repository.EmployeeRepository;
import com.example.demo.dto.CreateEmployeeRequest;
import com.example.demo.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee create(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = createEmployeeRequest.to();
        return employeeRepository.create(employee);
    }

    public Employee getById(String id) {
        return employeeRepository.getById(id);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.getAllEmployees();
    }
}
