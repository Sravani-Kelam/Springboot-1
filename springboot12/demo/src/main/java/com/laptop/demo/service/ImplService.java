package com.laptop.demo.service;

import com.laptop.demo.dto.LapDto;
import com.laptop.demo.entity.LapEntity;
import com.laptop.demo.repository.LapRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImplService implements LapService{

    @Autowired
    private LapRepository lapRepository;

    public LapDto saveLap(LapDto lapDto){
        LapEntity lapEntity=new LapEntity(
                lapDto.getId(),
                lapDto.getName(),
                lapDto.getStorage(),
                lapDto.getVersion()
        );
        LapEntity saveLap=lapRepository.save(lapEntity);

        LapDto savelapDto=new LapDto(
                saveLap.getId(),
                saveLap.getName(),
                saveLap.getStorage(),
                saveLap.getVersion()
        );
        return savelapDto;
    }
    public  LapDto getByid(int id){
        LapEntity lapEntity=lapRepository.findByid(id)
                .orElseThrow(()->new RuntimeException("lap is not found"));
        return new LapDto(
                lapEntity.getId(),
                lapEntity.getName(),
                lapEntity.getStorage(),
                lapEntity.getVersion()
        );
    }
    public LapDto updateLap(int id,LapDto lapDto){
        LapEntity existingLap=lapRepository.findByid(id)
                .orElseThrow(()->new RuntimeException("lap is not found by id:"+id));

        existingLap.setName(lapDto.getName());
        existingLap.setStorage(lapDto.getStorage());
        existingLap.setVersion(lapDto.getVersion());

        LapEntity updatedLap=lapRepository.save(existingLap);

        return new LapDto(
                updatedLap.getId(),
                updatedLap.getName(),
                updatedLap.getStorage(),
                updatedLap.getVersion()
        );
    }
    public LapEntity deleteLap(int id){
        LapEntity existingLap=lapRepository.findByid(id)
                .orElseThrow(()->new RuntimeException("lap is not found by id:"+id));
        lapRepository.deleteById(id);

        return existingLap;
    }
}
