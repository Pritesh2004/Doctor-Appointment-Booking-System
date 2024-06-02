package doctorappointment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import doctorappointment.model.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment, Integer> {
	
	@Query(value = "SELECT * from appointment_details where id=?1", nativeQuery=true)
	public Appointment findById(int id);
	
	public List<Appointment> findByEmail(String email);
	
	@Query(value = "SELECT * from appointment_details where doctor_email=?1", nativeQuery=true)
	public List<Appointment> findByDoctorEmail(String doctorEmail);


	@Query(value = "SELECT * from appointment_details where appointment_status=?1 && doctorEmail=?2 ", nativeQuery=true)
	public  List<Appointment> findExistingAppointments(boolean appointment_status, String doctorEmail);
	
	@Query(value = "SELECT * from appointment_details where doctor_email=?1 && appointment_date=?2 && appointment_time=?3 ", nativeQuery=true)
	public  Appointment findByDoctorEmailAppointmentDateAndTime(String doctorEmail, String appointment_date, String appointment_time);
	

	
}
