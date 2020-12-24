package com.Ikart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Ikart.domain.Account;

public interface AccountRepository extends JpaRepository<Account,String>{

}
