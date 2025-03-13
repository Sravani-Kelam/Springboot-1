package com.pro.jpa4.runner;

import com.pro.jpa4.document.EmpDocument;
import com.pro.jpa4.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    EmpDocument empDoc;
    @Override
    public void run(String... args) throws Exception {
        empDoc.save(new Employee(11,"Siri","hyd",75000.75));
        System.out.println("New Document Created in MongoDB Collection");
    }
}