package com.company.demo.reposity;

import com.company.demo.dto.CompanyDto;
import com.company.demo.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Companyrepository extends JpaRepository<Company,Long> {
    Optional<Company> findById(long id);
    }
