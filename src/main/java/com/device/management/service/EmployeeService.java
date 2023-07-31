package com.device.management.service;

import com.device.management.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeById(long id);
    List<Employee> getAllEmployee();
}
