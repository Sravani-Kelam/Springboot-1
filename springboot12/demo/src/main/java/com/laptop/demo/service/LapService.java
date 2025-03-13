package com.laptop.demo.service;

import com.laptop.demo.dto.LapDto;

public interface LapService {
    LapDto saveLap(LapDto lapDto);
    LapDto getByid(int id);
    LapDto updateLap(int id,LapDto lapDto);
}
