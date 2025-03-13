package com.pro.jpa2.runner;

import com.pro.jpa2.Model.Employee;
import com.pro.jpa2.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    EmployeeRepository emp_Repo;

    @Override
    public void run(String... args) throws Exception {
        emp_Repo.save(new Employee("Rahul",45000.45));
        emp_Repo.save(new Employee("Soan",55000.55));
        emp_Repo.save(new Employee("Priya",65000.65));
    }


}
