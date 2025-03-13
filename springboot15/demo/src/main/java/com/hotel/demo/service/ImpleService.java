package com.hotel.demo.service;

import com.hotel.demo.entity.HotelEntity;
import com.hotel.demo.repository.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImpleService {

    @Autowired
    private HotelRepository hotelRepository;

    public HotelEntity saveHotel(MultipartFile file, String name, double money) throws SQLException, IOException {
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setName(name);
        hotelEntity.setMoney(money);
        if (!file.isEmpty()) {
            byte[] photoBytes = file.getBytes();
           // Blob photoBlob = new SerialBlob(photoBytes);
            hotelEntity.setPhoto(photoBytes);
        }
        return hotelRepository.save(hotelEntity);
    }
    public Optional<HotelEntity> getHotel(Integer id)throws SQLException,IOException{
        return hotelRepository.findById(id);
    }
    public HotelEntity updateHotel(Integer id,String name,Double money,byte[] photobytes) {
        HotelEntity hotelEntity = hotelRepository.findByid(id).get();
        if (name != null) hotelEntity.setName(name);
        if (money != null) hotelEntity.setMoney(money);
        if (photobytes != null && photobytes.length > 0) {  // Ensure correct variable name
            byte[] photobytes1 = new byte[0];
            hotelEntity.setPhoto(photobytes1);
        }

        return hotelRepository.save(hotelEntity);
    }
    public void deleteHotel(int id){
        Optional<HotelEntity>theHotelEntity=hotelRepository.findByid(id);
        if (theHotelEntity.isPresent()){
            hotelRepository.deleteById(id);
        }
    }
}
