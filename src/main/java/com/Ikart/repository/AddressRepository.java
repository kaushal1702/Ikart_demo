package com.Ikart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ikart.domain.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{

}
