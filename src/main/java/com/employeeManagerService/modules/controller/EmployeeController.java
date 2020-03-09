package com.employeeManagerService.modules.controller;


import com.employeeManagerService.modules.model.Employee;
import com.employeeManagerService.modules.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/find-all")
    public ResponseEntity<List<Employee>> findAll() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping("/save")
    public List<Employee> create(@RequestBody Employee employee) {
        //return ResponseEntity.ok(employeeService.save(employee));
        employeeService.save(employee);
        return employeeService.findAll();
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Employee> findById(@PathVariable Long id) {
        Optional<Employee> person = employeeService.findById(id);
        if (!person.isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(person.get());
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @PutMapping("/update-by-id/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        if (!employeeService.findById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(employeeService.save(employee));
    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!employeeService.findById(id).isPresent()) {
            System.out.println("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}