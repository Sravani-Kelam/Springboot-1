package com.phone.demo.service;

import com.phone.demo.dto.PhnDto;


public interface PhoneService {

    PhnDto savephn(PhnDto phnDto);

    PhnDto getByphnnum(long phnnum);

    PhnDto updatePhone(long phnnum,PhnDto phnDto);
}
