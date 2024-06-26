package com.example.demo.service;

import com.example.demo.dto.UpdateEmployeeRequest;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.dto.CreateEmployeeRequest;
import com.example.demo.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee create(CreateEmployeeRequest createEmployeeRequest) throws SQLException {
        Employee employee = createEmployeeRequest.to();
        return employeeRepository.createUpgraded(employee);
    }

    public Employee getById(String id) {
        return employeeRepository.getById(id);
    }

    public List<Employee> getAllEmployee() throws SQLException {
        return employeeRepository.getAllEmployees();
    }

    public Employee updateEmployee(String id, UpdateEmployeeRequest request) {
        Employee employee = request.to(id);
        return employeeRepository.updateEmployee(employee);
    }

    public Employee deleteEmployee(String id) {
        return employeeRepository.deleteEmployee(id);
    }
}
