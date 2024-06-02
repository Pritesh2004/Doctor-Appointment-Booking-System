package doc.log.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private String username;
	
	private String email;
	
	private String password;
	
	private String speciality;
	

	
	private String phone;



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
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



	public String getSpeciality() {
		return speciality;
	}



	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public Doctor(Long id, String name, String username, String email, String password, String speciality,
			String phone) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.speciality = speciality;
		this.phone = phone;
	}



	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", username=" + username + ", email=" + email + ", password="
				+ password + ", speciality=" + speciality + ", phone=" + phone + "]";
	}
	


}
