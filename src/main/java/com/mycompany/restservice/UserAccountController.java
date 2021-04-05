package com.mycompany.restservice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
public class UserAccountController {

	@Autowired
	public UserAccountService accountService;
	
	@RequestMapping("/accounts")
	public List<UserAccount> getAllUserAccount() {
		return accountService.getAllUserAccount();
	}
	
	@RequestMapping("/accounts/{id}")
	public Optional<UserAccount> getUserAccount(@PathVariable long id) {
		return accountService.getUserAccount(id);
	}
	
	@PostMapping("/accounts")
	public ResponseEntity<String> addUserAccount(@Valid @RequestBody UserAccount userAccount) {
		accountService.addUserAccount(userAccount);
		return ResponseEntity.ok("User Accoud is added Successfully");
	}
	
	@PutMapping("/accounts")
	public ResponseEntity<String> updateUserAccount(@Valid  @RequestBody UserAccount userAccount) {
		accountService.updateUserAccount(userAccount);
		return ResponseEntity.ok("User Accoud is updated Successfully");
	}
	@DeleteMapping("/accounts/{id}")
	public ResponseEntity<String> deleteUserAccount(@PathVariable long id) {
		accountService.deleteUserAccount(id);
		return ResponseEntity.ok("Deleted Sucessfully");
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException ex) {
	    Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
}
