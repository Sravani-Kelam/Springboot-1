package com.company.demo.service;

import com.company.demo.dto.CompanyDto;

public interface Service {

    CompanyDto saveCompany(CompanyDto companyDto);

    CompanyDto getByid(long id);

    CompanyDto updateCompany(long id ,CompanyDto companyDto);
}
