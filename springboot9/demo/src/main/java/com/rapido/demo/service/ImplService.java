package com.rapido.demo.service;

import com.rapido.demo.dto.RapidoDto;
import com.rapido.demo.entity.RapidoEntity;
import com.rapido.demo.repository.RapidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImplService implements RapidoService{

    @Autowired
    private RapidoRepository rapidoRepository;

    public RapidoDto saveRapido(RapidoDto rapidoDto){
        RapidoEntity rapidoEntity=new RapidoEntity(
                rapidoDto.getId(),
                rapidoDto.getName(),
                rapidoDto.getPhnnum(),
                rapidoDto.getPlace()
        );
        RapidoEntity saveRapido=rapidoRepository.save(rapidoEntity);

        RapidoDto saverapidoDto=new RapidoDto(
                saveRapido.getId(),
                saveRapido.getName(),
                saveRapido.getPhnnum(),
                saveRapido.getPlace()
        );
        return saverapidoDto;
    }
    public RapidoDto getByid(int id){
        RapidoEntity rapidoEntity=rapidoRepository.findByid(id)
                .orElseThrow(()->new RuntimeException("Rpido is not found by id:"+id));
        return new RapidoDto(
                rapidoEntity.getId(),
                rapidoEntity.getName(),
                rapidoEntity.getPhnnum(),
                rapidoEntity.getPlace()
        );
    }
    public RapidoDto updateRapido(int id,RapidoDto rapidoDto){
        RapidoEntity existingRapido=rapidoRepository.findByid(id)
                .orElseThrow(()->new RuntimeException("rapido is not found by id:"+id));

        existingRapido.setName(rapidoDto.getName());
        existingRapido.setPhnnum(rapidoDto.getPhnnum());
        existingRapido.setPlace(rapidoDto.getPlace());

        RapidoEntity updateRapidoEntity=rapidoRepository.save(existingRapido);

        return new RapidoDto(
                updateRapidoEntity.getId(),
                updateRapidoEntity.getName(),
                updateRapidoEntity.getPhnnum(),
                updateRapidoEntity.getPlace()
        );
    }
    public RapidoEntity deleteRapido(int id){
        RapidoEntity existingRapidoEntity=rapidoRepository.findByid(id)
                .orElseThrow(()->new RuntimeException("rapido is not by id:"+id));

        rapidoRepository.deleteById(id);
        return existingRapidoEntity;
    }
}
