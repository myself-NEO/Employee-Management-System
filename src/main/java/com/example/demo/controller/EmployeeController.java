package com.example.demo.controller;

import com.example.demo.dto.CreateEmployeeRequest;
import com.example.demo.models.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    /**
     * Employee Management System
     */

    /**
     * Input  -> Query parameter eg- abc?a=a&b=b;
     *        -> Path variable eg - abc/a/a/b/b;
     *        -> request body (json data)
     */

    /**
     * MVC architecture
     */

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody CreateEmployeeRequest employeeRequest) {
        return employeeService.create(employeeRequest);
    }

    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable("employeeId") String id) {
        return employeeService.getById(id);
    }

    @GetMapping("/allEmployees")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }
}
