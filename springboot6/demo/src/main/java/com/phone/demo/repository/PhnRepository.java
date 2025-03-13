package com.phone.demo.repository;

import com.phone.demo.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PhnRepository extends JpaRepository<Phone,Integer> {
    Optional<Phone> findByphnnum(long phnnum);

    void deleteByphnnum(long phnnum);
}
