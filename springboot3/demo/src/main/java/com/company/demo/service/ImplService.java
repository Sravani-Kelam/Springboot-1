package com.company.demo.service;

import com.company.demo.dto.CompanyDto;
import com.company.demo.entity.Company;
import com.company.demo.reposity.Companyrepository;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
//@AllArgsConstructor

public class ImplService implements Service{
    @Autowired
    private Companyrepository companyrepository;

    @Override
    public CompanyDto saveCompany(CompanyDto companyDto){
        Company company=new Company(
             companyDto.getId(),
             companyDto.getDepartment(),
             companyDto.getNetworth()
        );
        Company saveCompany= companyrepository.save(company);

        CompanyDto savecompanyDto=new CompanyDto(
                saveCompany.getId(),
                saveCompany.getDepartment(),
                saveCompany.getNetworth()
        );
        return  savecompanyDto;
    }

    @Override
    public CompanyDto getByid(long id) {
        Company company = companyrepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));
        return new CompanyDto(
                company.getId(),
                company.getDepartment(),
                company.getNetworth()
        );
    }
    public CompanyDto updateCompany(long id, CompanyDto companyDto){
        Company existingCompany=companyrepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Companay not found with id:"+id));

        existingCompany.setDepartment(companyDto.getDepartment());
        existingCompany.setNetworth(companyDto.getNetworth());

        Company updatedCompany = companyrepository.save(existingCompany);

        return new CompanyDto(
                updatedCompany.getId(),
                updatedCompany.getDepartment(),
                updatedCompany.getNetworth()
        );
    }
    public Company deleteCompany(long id){
        Company existingCompany=companyrepository.findById(id)
                .orElseThrow(()->new RuntimeException("Company not found with id:"+id));
        companyrepository.deleteById(id);

        return existingCompany;
    }
}
