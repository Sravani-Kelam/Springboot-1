package com.pro.jpa6.conductor.services.impl;
import com.pro.jpa6.conductor.dto.ConductorDto;
import com.pro.jpa6.conductor.entity.Conductor;
import com.pro.jpa6.conductor.repository.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConductorServiceImpl {

    @Autowired
    private ConductorRepository conductorRepository;

    @Override
    public ConductorDto saveconductor(ConductorDto conductorDto){
        Conductor conductor=new Conductor(
                conductorDto.getPhn(),
                conductorDto.getName(),
                conductorDto.getSurname()
        );
        Conductor saveconductor= conductorRepository.save(conductor);
        ConductorDto studentDto1=new ConductorDto(
                saveconductor.getPhn(),
                saveconductor.getName(),
                saveconductor.getSurname()
        );
        return conductorDto;
    }
    public Conductor getconductor(int phn){
        Conductor conductor= conductorRepository.findByphn(phn);
        return conductor;
    }
        public ConductorDto updateConductor(int phn, ConductorDto conductorDto){
            Conductor existingConductor = conductorRepository.findById(phn)
                    .orElseThrow(()->new RuntimeException("Conductor not found by phn:"+phn));

            existingConductor.setName(conductorDto.getName());
            existingConductor.setSurname(conductorDto.getSurname());

            Conductor updatedConductor= conductorRepository.save(existingConductor);
            return new ConductorDto(
                    updatedConductor.getPhn(),
                    updatedConductor.getName(),
                    updatedConductor.getSurname()
            );
        }
        public ConductorDto deleteConductor(int phn){
        ConductorDto conductorDto= conductorRepository.deleteByphn(phn);
        return conductorDto;
        }
    }

