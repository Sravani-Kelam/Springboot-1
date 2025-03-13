package com.pro.jpa4.document;

import com.pro.jpa4.model.Employee;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

@Document
public interface EmpDocument extends MongoRepository<Employee,Integer> {
}