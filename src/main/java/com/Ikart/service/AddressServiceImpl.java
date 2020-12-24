package com.Ikart.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ikart.domain.Account;
import com.Ikart.domain.Address;
import com.Ikart.dto.AddressDTO;
import com.Ikart.exceptions.InvalidAddressId;
import com.Ikart.exceptions.InvalidStateException;
import com.Ikart.repository.AccountRepository;
import com.Ikart.repository.AddressRepository;
import com.Ikart.validations.Validation;

@Service("addressService")
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private AccountRepository accountRepository;
	
	public String createAddress(String email , AddressDTO addressDTO) throws InvalidStateException{
		
		if(!(Validation.validateState(addressDTO.getState()))) {
			throw new InvalidStateException("Invalid state of India");
		}
		Optional<Account> optionalAccount = accountRepository.findById(email);
		Account accountEntity = optionalAccount.get();
		accountEntity.setAddress(AddressDTO.prepareAddressEntity(addressDTO));
		accountRepository.save(accountEntity);
		//addressRepository.saveAndFlush(AddressDTO.prepareAddressEntity(addressDTO));
		return "Address added succcessfully";
		
	}	
	
	public AddressDTO viewAddress(String email , int addressId) throws InvalidAddressId{
		Optional<Account> optionalAccount = accountRepository.findById(email);
		Account accountEntity = optionalAccount.get();
		
		if(accountEntity.getAddress().getAddressId()!=addressId) {
			throw new InvalidAddressId("Address ID is invalid");
		}
		
		return Address.prepareAddressDTO(accountEntity.getAddress()) ;
		
		
	}
	
	public String updateAddress(String email,int addressId,AddressDTO addressDTO) throws InvalidStateException,InvalidAddressId{
		
		Optional<Account> optionalAccount = accountRepository.findById(email);
		Account accountEntity = optionalAccount.get();
		
		if(accountEntity.getAddress().getAddressId()!=addressId) {
			throw new InvalidAddressId("Address ID is invalid");
		}
		
		
		if(!(Validation.validateState(addressDTO.getState()))) {
			throw new InvalidStateException("Invalid state of India");
		}
		
		accountEntity.getAddress().setPhoneNo(addressDTO.getPhoneNo());
		accountEntity.getAddress().setFullAddress(addressDTO.getFullAddress());
		accountEntity.getAddress().setPin(addressDTO.getPin());
		accountEntity.getAddress().setCity(addressDTO.getCity());
		accountEntity.getAddress().setState(addressDTO.getState());
		//accountEntity.setAddress(AddressDTO.prepareAddressEntity(addressDTO));
		accountRepository.save(accountEntity);
		//addressRepository.saveAndFlush(AddressDTO.prepareAddressEntity(addressDTO));
		return "Address modified succcessfully";
		
	}
	
	public String removeAddress(String email,int addressId) throws InvalidAddressId{

		Optional<Account> optionalAccount = accountRepository.findById(email);
		Account accountEntity = optionalAccount.get();

		if(accountEntity.getAddress().getAddressId()!=addressId) {
			throw new InvalidAddressId("Address ID is invalid");
		}
		
		accountEntity.setAddress(null);
		accountRepository.save(accountEntity);
		addressRepository.deleteById(addressId);
		return "Address deleted succcessfully";
	}

}
