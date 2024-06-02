package loginsignup.model;

import jakarta.persistence.*;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Patient {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String email;
	private String password;
	private String phone;
	private String gender;
	private String firstName;
	private String lastName;
	
	public Patient(Long id, String email, String password, String phone, String gender, String firstName,
			String lastName) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.gender = gender;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
}
