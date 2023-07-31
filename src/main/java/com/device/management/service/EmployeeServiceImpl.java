package com.device.management.service;

import com.device.management.exception.ResourceNotFoundException;
import com.device.management.model.Employee;
import com.device.management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        }
        throw new ResourceNotFoundException("Can't find the employee :" + id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> allEmployeeList = new ArrayList<>();
        employeeRepository.findAll().iterator().forEachRemaining(allEmployeeList :: add);
        return allEmployeeList;
    }
}
