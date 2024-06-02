package doctorappointment.service;

import java.util.List;

import doctorappointment.model.Appointment;

public interface AppointmentService {

//	Creating appointment
	public Appointment bookAppointment(Appointment appointment) throws Exception;
	
//	Getting appointment using patient_id
	public List<Appointment> getAppointmentByPatientEmail(String email);
	
	public List<Appointment> getAppointmentByDoctorEmail(String doctorEmail);
	
//	Deleting Appointment using id
	public void deleteAppointment(int id);

	Appointment updateAppointmentStatus(int id);
	

	Appointment rejectAppointment(int id);


	
	
}
