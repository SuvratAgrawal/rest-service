package com.mycompany.restservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name= "user_accounts")
public class UserAccount {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	@Column(nullable = false, length = 15)
	@NotBlank(message = "name is mandatory field")
	@Size(min = 3, max = 15, message = "name length should be 3-15 chraacters")
	String name;

	@Column(nullable = false, length = 15)   
	@NotNull(message = "phone is mandatory field")
	@DecimalMin(value="100000000",message = "phone number should have atleast 9 digits")
	@DecimalMax(value="999999999999",message = "phone number should not have more than 12 digits")
	long phone;
	
	@Column(nullable = false, length = 200)
	@NotBlank(message = "email is mandatory field")
	@Size(max = 200, message = "email length can't be greater than 200 chraacters")
	String email;

	@Column(nullable = true, length = 200)
	@Size(max = 200, message = "address length can't be greater than 200 chraacters")
	String address;
	
	@Column(nullable = false, length = 56)
	@NotBlank(message = "country is mandatory field")
	@Size(max = 200, message = "country name length can't be greater than 56 chraacters")
	String country;

	@Column(nullable = false, length = 50)
	@NotBlank(message = "department is mandatory field")
	@Size(max = 200, message = "department name length can't be greater than 50 chraacters")
	String department;
	
	public UserAccount(long id,
			@NotBlank(message = "name is mandatory field") @Size(min = 3, max = 15, message = "name length should be 3-15 chraacters") String name,
			@Size(min = 9, max = 12, message = "phone number should have 9-12 digit") long phone,
			@NotBlank(message = "email is mandatory field") @Size(max = 200, message = "email length can't be greater than 200 chraacters") String email,
			@Size(max = 200, message = "address length can't be greater than 200 chraacters") String address,
			@NotBlank(message = "country is mandatory field") @Size(max = 200, message = "country name length can't be greater than 56 chraacters") String country,
			@NotBlank(message = "department is mandatory field") @Size(max = 200, message = "department name length can't be greater than 50 chraacters") String department) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.country = country;
		this.department = department;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public UserAccount() {

	}

	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
