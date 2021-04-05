package com.mycompany.restservice;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {
	
    @Autowired
	UserAccountRepository userAccountRepository;
   
	 
	public List<UserAccount> getAllUserAccount() {
		List<UserAccount> userAccountList = new ArrayList<>();
		userAccountRepository.findAll()
		.forEach(userAccountList::add);
		return userAccountList;
	}

	public Optional<UserAccount> getUserAccount(long id) {
		return userAccountRepository.findById(id);
		
	}

	public void addUserAccount(UserAccount userAccount) {
		userAccountRepository.save(userAccount);
	}
	

	public void updateUserAccount(UserAccount userAccount) {
		userAccountRepository.save(userAccount);
	}
	public void deleteUserAccount(long id) {
		userAccountRepository.deleteById(id);
		
	}
	
}
