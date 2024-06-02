package available.doctor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Available-Doctor")
public class DoctorDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long dr_id;
	
	
	private String dr_firstName;
	
	private String dr_lastName;
	
	private String email;
	
	private String dr_speciality;
	
	private boolean available;
	
	private String phone;

	public long getDr_id() {
		return dr_id;
	}

	public void setDr_id(long dr_id) {
		this.dr_id = dr_id;
	}

	public String getDr_firstName() {
		return dr_firstName;
	}

	public void setDr_firstName(String dr_firstName) {
		this.dr_firstName = dr_firstName;
	}

	public String getDr_lastName() {
		return dr_lastName;
	}

	public void setDr_lastName(String dr_lastName) {
		this.dr_lastName = dr_lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDr_speciality() {
		return dr_speciality;
	}

	public void setDr_speciality(String dr_speciality) {
		this.dr_speciality = dr_speciality;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public DoctorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DoctorDetails(long dr_id, String dr_firstName, String dr_lastName, String email, String dr_speciality,
			boolean available, String phone) {
		super();
		this.dr_id = dr_id;
		this.dr_firstName = dr_firstName;
		this.dr_lastName = dr_lastName;
		this.email = email;
		this.dr_speciality = dr_speciality;
		this.available = available;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "DoctorDetails [dr_id=" + dr_id + ", dr_firstName=" + dr_firstName + ", dr_lastName=" + dr_lastName
				+ ", email=" + email + ", dr_speciality=" + dr_speciality + ", available=" + available + ", phone="
				+ phone + "]";
	}	
	
	
	

	
	
	
	
	

}
