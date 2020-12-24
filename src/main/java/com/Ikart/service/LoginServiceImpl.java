package com.Ikart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ikart.domain.Account;
import com.Ikart.dto.LoginDTO;
import com.Ikart.repository.AccountRepository;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public boolean login(LoginDTO loginDTO) {
		Optional<Account> optionalAccount = accountRepository.findById(loginDTO.getEmail());
		
		if(optionalAccount.isPresent()) {
			Account accountEntity = optionalAccount.get();
	
			if(accountEntity.getPassword().equals(loginDTO.getPassword())) {
				return true ;
			}
		}
		return false;
		
	}
	

}
