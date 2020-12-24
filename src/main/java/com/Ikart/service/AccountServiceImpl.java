package com.Ikart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ikart.domain.Account;
import com.Ikart.dto.AccountDTO;
import com.Ikart.dto.AccountDTO2;
import com.Ikart.exceptions.BuyerAlreadyExistsException;
import com.Ikart.repository.AccountRepository;


@Service("accountService")
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	public String createAccount(AccountDTO accountDTO) throws BuyerAlreadyExistsException {
		
		//System.out.println("inside accountservice create");
		
		if(accountRepository.existsById(accountDTO.getEmail())) {
			throw new BuyerAlreadyExistsException("email ID is already used");
		}
		
		accountRepository.saveAndFlush(AccountDTO.prepareAccountEntity(accountDTO));
		
		//System.out.println("after adding account");
		
		return "Buyer added succcessfully";
		
	}
	
	public String updateAcct(String email,AccountDTO2 accountDTO2) {
		Optional<Account> optionalAccount = accountRepository.findById(email);
		Account accountEntity = optionalAccount.get();
		accountEntity.setName(accountDTO2.getName());
		accountEntity.setPassword(accountDTO2.getPassword());
		accountRepository.save(accountEntity);
		return "Details of userid " + email + " has been updated successfully.";
	}

}
