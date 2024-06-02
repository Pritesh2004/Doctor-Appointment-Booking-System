package doctorappointment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doctorappointment.model.Appointment;
import doctorappointment.repository.AppointmentRepo;

@Service
public class AppointmentSeviceImpl implements AppointmentService{

	@Autowired
	private AppointmentRepo appointmentRepo;
	
	@Override
	public Appointment bookAppointment(Appointment appointment) throws Exception {
		// TODO Auto-generated method stub
		Appointment local = this.appointmentRepo.findByDoctorEmailAppointmentDateAndTime(appointment.getDoctorEmail(), appointment.getAppointment_date(), appointment.getAppointment_time());

		if (local != null) {
			System.out.println("Appointment already present");
			throw new Exception("Appointment already present");
		} else {

			appointment = this.appointmentRepo.save(appointment);
			System.out.println(local);
		}

		return appointment;
	}

	

	@Override
	public void deleteAppointment(int id) {
		// TODO Auto-generated method stub
		this.appointmentRepo.deleteById(id);
		
	}



	@Override
	public List<Appointment> getAppointmentByPatientEmail(String email) {
		// TODO Auto-generated method stub
		return this.appointmentRepo.findByEmail(email);
	}



	@Override
	public List<Appointment> getAppointmentByDoctorEmail(String doctorEmail) {
		// TODO Auto-generated method stub
		return this.appointmentRepo.findByDoctorEmail(doctorEmail);
	}
	
		@Override
		public Appointment updateAppointmentStatus(int id) {
	        Appointment appointment = appointmentRepo.findById(id);
	            
	        
	        appointment.setAppointment_status(true);
	        return appointmentRepo.save(appointment);
	    }



		@Override
		public Appointment rejectAppointment(int id) {

			
			 Appointment appointment = appointmentRepo.findById(id);
	            
		        
		        appointment.setAppointment_rejected(true);
		        return appointmentRepo.save(appointment);
		}



	
}
