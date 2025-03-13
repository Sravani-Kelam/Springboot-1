package com.phone.demo.service;

import com.phone.demo.dto.PhnDto;
import com.phone.demo.entity.Phone;
import com.phone.demo.repository.PhnRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class ImplService implements PhoneService{

    @Autowired
    private PhnRepository phnrepo;

    @Override
    public PhnDto savephn(PhnDto phnDto) {
            Phone phone=new Phone(
                    phnDto.getPhnnum(),
                    phnDto.getBrand(),
                    phnDto.getPrice()
            );
            Phone savePhone=phnrepo.save(phone);

            PhnDto savephnDto=new PhnDto(
                    savePhone.getPhnnum(),
                    savePhone.getBrand(),
                    savePhone.getPrice()
            );
            return savephnDto;
        }

    @Override
    public PhnDto getByphnnum(long phnnum) {
        Phone phone=phnrepo.findByphnnum(phnnum)
                .orElseThrow(()->new RuntimeException("phone not found by phnnum"));
        return new PhnDto(
                phone.getPhnnum(),
                phone.getBrand(),
                phone.getPrice()
        );
    }

        public PhnDto updatePhone(long phnnum,PhnDto phnDto){
        Phone existingPhone=phnrepo.findByphnnum(phnnum)
                .orElseThrow(()->new RuntimeException("phone is not found by phnnum:"+phnnum));

        existingPhone.setBrand(phnDto.getBrand());
        existingPhone.setPrice(phnDto.getPrice());

        Phone updatedPhone=phnrepo.save(existingPhone);
        return  new PhnDto(
                updatedPhone.getPhnnum(),
                updatedPhone.getBrand(),
                updatedPhone.getPrice()
        );
        }
    public void deletePhone(long phnnum) {
        Phone existingPhone = phnrepo.findByphnnum(phnnum)
                .orElseThrow(() -> new RuntimeException("Phone not found by phnnum: " + phnnum));

        phnrepo.delete(existingPhone);
    }

}


