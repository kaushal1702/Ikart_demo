package com.Ikart.service;

import com.Ikart.dto.AccountDTO;
import com.Ikart.dto.AccountDTO2;
import com.Ikart.exceptions.BuyerAlreadyExistsException;

public interface AccountService {
	
	public String createAccount(AccountDTO accountDTO) throws BuyerAlreadyExistsException;
	public String updateAcct(String email,AccountDTO2 accountDTO2);

}
