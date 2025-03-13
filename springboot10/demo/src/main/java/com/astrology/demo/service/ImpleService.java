package com.astrology.demo.service;

import com.astrology.demo.dto.AstroDto;
import com.astrology.demo.entity.AstroEntity;
import com.astrology.demo.repository.AstroRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImpleService {

    @Autowired
    private AstroRepository astroRepository;
    public AstroDto saveAstroEntity(AstroDto astroDto) {
        AstroEntity astroEntity = new AstroEntity(
                astroDto.getId(),
                astroDto.getName(),
                astroDto.getPhnnum()
        );
        AstroEntity saveAstro = astroRepository.save(astroEntity);

        AstroDto saveastroDto = new AstroDto(
                saveAstro.getId(),
                saveAstro.getName(),
                saveAstro.getPhnnum()
        );
        return saveastroDto;
    }
    public AstroDto getByid(int id){
        AstroEntity astroEntity=astroRepository.findByid(id)
                .orElseThrow(()->new RuntimeException("astro is not found"));
        return new AstroDto(
                astroEntity.getId(),
                astroEntity.getName(),
                astroEntity.getPhnnum()
        );
    }
    public AstroDto updateAstroEntity(int id,AstroDto astroDto){
        AstroEntity existingAstro=astroRepository.findByid(id)
                .orElseThrow(()->new RuntimeException("astro is not found by id:"+id));

        existingAstro.setName(astroDto.getName());
        existingAstro.setPhnnum(astroDto.getPhnnum());

        AstroEntity updateAstroEntity=astroRepository.save(existingAstro);

        return new AstroDto(
                updateAstroEntity.getId(),
                updateAstroEntity.getName(),
                updateAstroEntity.getPhnnum()
        );
    }
    public AstroEntity deleteAstro(int id){
        AstroEntity existingAstroEntity=astroRepository.findByid(id)
                .orElseThrow(()->new RuntimeException("astro is not found by id:"+id));
        astroRepository.deleteById(id);
        return existingAstroEntity;
    }
}
