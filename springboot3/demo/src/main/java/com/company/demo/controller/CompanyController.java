package com.company.demo.controller;

import com.company.demo.dto.CompanyDto;
import com.company.demo.entity.Company;
import com.company.demo.service.ImplService;
import com.company.demo.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {
    @Autowired
    private ImplService service;

    @PostMapping("/savecompany")
    public ResponseEntity<CompanyDto> saveCompanies(@RequestBody CompanyDto companyDto) {
        CompanyDto savedCompany = service.saveCompany(companyDto);
        return new ResponseEntity<>(savedCompany, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> getCompany(@PathVariable long id) {
        CompanyDto company = service.getByid(id);
        return new ResponseEntity<>(company, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CompanyDto> updateCompany(@PathVariable long id,@RequestBody CompanyDto companyDto){
        CompanyDto updatedCompany= service.updateCompany(id,companyDto);
        return  new ResponseEntity<>(updatedCompany,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Company> deleteCompany(@PathVariable long id){
        Company company=service.deleteCompany(id);
        return new ResponseEntity<>(company,HttpStatus.OK);
    }
}
