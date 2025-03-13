package com.stations.demo.service;

import com.stations.demo.dto.StationDto;
import com.stations.demo.entity.StationEntity;
import com.stations.demo.repository.StationRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImplService implements StationService{
    @Autowired
    private StationRepository stationRepository;

    public StationDto saveStation(StationDto stationDto){
        StationEntity stationEntity=new StationEntity(
                stationDto.getId(),
                stationDto.getName(),
                stationDto.getPlatnum()
        );
        StationEntity saveStationEntity=stationRepository.save(stationEntity);

        StationDto savestationDto=new StationDto(
                saveStationEntity.getId(),
                saveStationEntity.getName(),
                saveStationEntity.getPlatnum()
        );
        return savestationDto;
    }
    @Override
    public  StationDto getByid(int id){
        StationEntity stationEntity=stationRepository.findByid(id)
                .orElseThrow(()->new RuntimeException("station is not found by id:"+id));
        return new StationDto(
                stationEntity.getId(),
                stationEntity.getName(),
                stationEntity.getPlatnum()
        );
    }
    public StationDto updateStation(int id,StationDto stationDto){
        StationEntity existingStation=stationRepository.findByid(id)
                .orElseThrow(()->new RuntimeException("station is not found by id:"+id));

        existingStation.setName(stationDto.getName());
        existingStation.setPlatnum(stationDto.getPlatnum());

        StationEntity updatedStation=stationRepository.save(existingStation);
        return new StationDto(
                updatedStation.getId(),
                updatedStation.getName(),
                updatedStation.getPlatnum()
        );
    }
    public StationEntity deleteStationEntity(int id){
        StationEntity existingStation=stationRepository.findByid(id)
                .orElseThrow(()->new RuntimeException("station not found by id:"+id));
        stationRepository.deleteById(id);

        return existingStation;
    }
}
