package com.astrology.demo.service;

import com.astrology.demo.dto.AstroDto;

public interface AstroService {
    AstroDto saveAstroDto(AstroDto astroDto);
    AstroDto getByid(int id);
    AstroDto updateAstroEntity(int id,AstroDto astroDto);
}
