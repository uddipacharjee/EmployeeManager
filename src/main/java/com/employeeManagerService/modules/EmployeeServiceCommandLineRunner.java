package com.employeeManagerService.modules;

import com.employeeManagerService.modules.model.Employee;
import com.employeeManagerService.modules.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class EmployeeServiceCommandLineRunner implements CommandLineRunner {

    private static final Logger log= LoggerFactory.getLogger(EmployeeServiceCommandLineRunner.class);

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void run(String... args) throws Exception {
        //Employee employee=new Employee("rabbi","engineer","r@g","soa",new Date("2020/02/01"),"018776655");
        //employeeService.save(employee);
        //log.info("New employee is created: "+ employee);
    }
}
