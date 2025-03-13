package com.rapido.demo.service;

import com.rapido.demo.dto.RapidoDto;

public interface RapidoService {
    RapidoDto saveRapido(RapidoDto rapidoDto);
    RapidoDto getByid(int id);
    RapidoDto updateRapido(int id,RapidoDto rapidoDto);
}
