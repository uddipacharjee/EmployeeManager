package com.employeeManagerService.modules.service;


import com.employeeManagerService.modules.model.Employee;
import com.employeeManagerService.modules.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    public Employee save(Employee person) {
        return employeeRepository.save(person);
    }

    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}