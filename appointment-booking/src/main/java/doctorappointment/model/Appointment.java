package doctorappointment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="appointment_details")
public class Appointment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	
	private String appointment_date;
	
	private String appointment_time;
	
	private String booking_time;
	
	private String dr_name;
	
	@Column(name="doctor_email")
	private String doctorEmail;
	
	private String dr_speciality;
	
	private String patient_firstName;
	
	private String patient_gender;
	
	private String reason;
	
	private String patient_lastName;
	
	private String email;
	
	private boolean appointment_status = false;
	
	private boolean appointment_rejected = false;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(int id, String appointment_date, String appointment_time, String booking_time, String dr_name,
			String doctorEmail, String dr_speciality, String patient_firstName, String patient_gender, String reason,
			String patient_lastName, String email, boolean appointment_status, boolean appointment_rejected) {
		super();
		this.id = id;
		this.appointment_date = appointment_date;
		this.appointment_time = appointment_time;
		this.booking_time = booking_time;
		this.dr_name = dr_name;
		this.doctorEmail = doctorEmail;
		this.dr_speciality = dr_speciality;
		this.patient_firstName = patient_firstName;
		this.patient_gender = patient_gender;
		this.reason = reason;
		this.patient_lastName = patient_lastName;
		this.email = email;
		this.appointment_status = appointment_status;
		this.appointment_rejected = appointment_rejected;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", appointment_date=" + appointment_date + ", appointment_time="
				+ appointment_time + ", booking_time=" + booking_time + ", dr_name=" + dr_name + ", doctorEmail="
				+ doctorEmail + ", dr_speciality=" + dr_speciality + ", patient_firstName=" + patient_firstName
				+ ", patient_gender=" + patient_gender + ", reason=" + reason + ", patient_lastName=" + patient_lastName
				+ ", email=" + email + ", appointment_status=" + appointment_status + ", appointment_rejected="
				+ appointment_rejected + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAppointment_date() {
		return appointment_date;
	}

	public void setAppointment_date(String appointment_date) {
		this.appointment_date = appointment_date;
	}

	public String getAppointment_time() {
		return appointment_time;
	}

	public void setAppointment_time(String appointment_time) {
		this.appointment_time = appointment_time;
	}

	public String getBooking_time() {
		return booking_time;
	}

	public void setBooking_time(String booking_time) {
		this.booking_time = booking_time;
	}

	public String getDr_name() {
		return dr_name;
	}

	public void setDr_name(String dr_name) {
		this.dr_name = dr_name;
	}

	public String getDoctorEmail() {
		return doctorEmail;
	}

	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	public String getDr_speciality() {
		return dr_speciality;
	}

	public void setDr_speciality(String dr_speciality) {
		this.dr_speciality = dr_speciality;
	}

	public String getPatient_firstName() {
		return patient_firstName;
	}

	public void setPatient_firstName(String patient_firstName) {
		this.patient_firstName = patient_firstName;
	}

	public String getPatient_gender() {
		return patient_gender;
	}

	public void setPatient_gender(String patient_gender) {
		this.patient_gender = patient_gender;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getPatient_lastName() {
		return patient_lastName;
	}

	public void setPatient_lastName(String patient_lastName) {
		this.patient_lastName = patient_lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAppointment_status() {
		return appointment_status;
	}

	public void setAppointment_status(boolean appointment_status) {
		this.appointment_status = appointment_status;
	}

	public boolean isAppointment_rejected() {
		return appointment_rejected;
	}

	public void setAppointment_rejected(boolean appointment_rejected) {
		this.appointment_rejected = appointment_rejected;
	}
	
	
	

}
