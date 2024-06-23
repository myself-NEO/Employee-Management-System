package com.example.demo.repository;

import com.example.demo.models.Address;
import com.example.demo.models.Department;
import com.example.demo.models.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

    private Connection connection;

    private final String url;
    private final String username;
    private final String dbpassword;

    public EmployeeRepository(
            @Value("${db_url}") String url,
            @Value("${db_username}") String username,
            @Value("${db_password}") String dbpassword) {
        this.url = url;
        this.username = username;
        this.dbpassword = dbpassword;
    }

    @PostConstruct
    public void init() {
        try {
            connectToDB();
            createEmployeeTable();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize EmployeeRepository", e);
        }
    }

    private void connectToDB() throws SQLException {
        this.connection = DriverManager.getConnection(url, username, dbpassword);
    }

    private void createEmployeeTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS employee(" +
                "id varchar(40) primary key, " +
                "name varchar(30), " +
                "age int, " +
                "department varchar(20), " +
                "address varchar(256))";
        try (Statement statement = this.connection.createStatement()) {
            statement.execute(sql);
        }
    }


    public Employee create(Employee employee) throws SQLException{
        String sql = "INSERT INTO employee (id, name, age, department, address) VALUES ('" +
                employee.getId() + "' , '" + employee.getName() + "' , '" + employee.getAge() + "' , '" +
                employee.getDepartment().name() + "' , '" + employee.getAddress().toString() + "')";

        Statement statement = this.connection.createStatement();
        statement.execute(sql);
        return employee;
    }

    public Employee createUpgraded(Employee employee) throws SQLException {

        // static queries
        String sql = "insert into employee (id, name, age, department, address) VALUES (?, ?, ?, ?, ?) ";

        PreparedStatement statement = this.connection.prepareStatement(sql);

        statement.setString(1, employee.getId());
        statement.setString(2, employee.getName());
        statement.setInt(3, employee.getAge());
        statement.setString(4, employee.getDepartment().name());
        statement.setString(5, employee.getAddress().toString());
        statement.execute();

        return employee;
    }

    public Employee getById(String id) {
        return null;
    }

    public List<Employee> getAllEmployees() throws SQLException {
        String sql = " SELECT * FROM employee";
        Statement statement = this.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql); // We should use this whenever we are using select query

        List<Employee> employeeList = new ArrayList<>();

        while(resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            Department department = Department.valueOf(resultSet.getString("department"));
            Address address = Address.fromString(resultSet.getString("address"));

            Employee employee = Employee.builder()
                    .id(id)
                    .name(name)
                    .age(age)
                    .department(department)
                    .address(address)
                    .build();

            employeeList.add(employee);
        }
        return employeeList;
    }

    public Employee updateEmployee(Employee employee) {
        return null;
    }

    private Employee merge(Employee oldData, Employee newData) {
        return null;
    }

    public Employee deleteEmployee(String id) {
        return null;
    }
}
