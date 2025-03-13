package com.colors.demo.service;

import com.colors.demo.entity.ColorEntity;
import com.colors.demo.repository.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;

import static org.springframework.boot.io.ApplicationResourceLoader.get;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@AllArgsConstructor
public class ImpleService implements ColorService {
    @Autowired
    private ColorRepository colorRepository;

    public ColorEntity saveColor(MultipartFile file, String name, double frequency) throws SQLException, IOException {
        ColorEntity colorEntity = new ColorEntity();
        colorEntity.setFrequency(frequency);
        colorEntity.setName(name);
        if (!file.isEmpty()) {
            byte[] photoBytes = file.getBytes();
            byte[]photoBlob = new byte[0];
            colorEntity.setPhoto(photoBlob);

        }
        return colorRepository.save(colorEntity);
    }
//    public ColorEntity getColor(MultipartFile file,String name,double frequency)throws SQLException,IOException{
//        ColorEntity colorEntity=new ColorEntity();
//        colorEntity.setName(name);
//        colorEntity.setFrequency(frequency);
//        if (!file.isEmpty()){
//            byte[] photoBytes=file.getBytes();
//            Blob photoBlob=new SerialBlob(photoBytes);
//            colorEntity.setPhoto(photoBlob);
//        }
//        return colorRepository.save(colorEntity);
//    }


    public Optional<ColorEntity> getColor(Integer id)throws SQLException,IOException{
        return colorRepository.findById(id);
    }

        public ColorEntity updateColor(Integer id,String name,Double frequency,byte[] photobytes) {
            ColorEntity colorEntity = colorRepository.findByid(id).get();
            if (name != null) colorEntity.setName(name);
            if (frequency != null) colorEntity.setFrequency(frequency);
            if (photobytes != null && photobytes.length > 0) {  // Ensure correct variable name
                byte[] photobytes1 = new byte[0];
                colorEntity.setPhoto(photobytes1);
            }

            return colorRepository.save(colorEntity);
            }

            public void deleteColor(int id){
        Optional<ColorEntity>theColorEntity=colorRepository.findByid(id);
        if (theColorEntity.isPresent()){
            colorRepository.deleteById(id);
        }
            }
        }

