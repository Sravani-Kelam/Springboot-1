package com.stations.demo.service;

import com.stations.demo.dto.StationDto;

public interface StationService {
    StationDto saveStation(StationDto stationDto);
    StationDto getByid(int id);
    StationDto updateStation(int id,StationDto stationDto);
}
