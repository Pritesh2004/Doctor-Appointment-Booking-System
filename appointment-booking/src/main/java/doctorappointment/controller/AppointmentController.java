package doctorappointment.controller;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import doctorappointment.model.Appointment;
import doctorappointment.repository.AppointmentRepo;
import doctorappointment.service.AppointmentService;
import doctorappointment.service.EmailSenderService;


@RestController
@RequestMapping("/appointment")
@CrossOrigin(origins = "*")
public class AppointmentController {

	@Autowired
	private AppointmentRepo appointmentRepo;
	
	@Autowired
	private AppointmentService appointmentService;
	
	   private final EmailSenderService emailService;

	    public AppointmentController(EmailSenderService emailService) {
	        this.emailService = emailService;
	    }
	
	@PostMapping("/")
	public ResponseEntity<Appointment> bookAppointment(@RequestBody Appointment appointment) throws Exception {
		
		Instant timestamp = Instant.now();

        // Convert the timestamp to a human-readable string
        String formattedTimestamp = timestamp.toString();
        
        appointment.setBooking_time(formattedTimestamp);
		
		String emailBody ="Dear " + appointment.getPatient_firstName()+" "+appointment.getPatient_lastName()+ ",\n\n" +
	            "Your appointment with Dr. " + appointment.getDr_name() + " on " + appointment.getAppointment_date() +
	            " has been registered wait for the doctors approval.\n\n" +
	            "Thank you for choosing our services.\n\n" +
	            "Best regards,\n" +
	            "Health Care System";

		emailService.sendEmail(appointment.getEmail(), "Appointment Registered", emailBody);
        
	
		Appointment newAppointment = this.appointmentService.bookAppointment(appointment);
		return new ResponseEntity<>(newAppointment, HttpStatus.CREATED);

	}

	@GetMapping("/{patient_email}")
	public ResponseEntity<List<Appointment>> getAppointmentByPatientEmail(@PathVariable("patient_email") String patient_email) {

		return ResponseEntity.ok(this.appointmentService.getAppointmentByPatientEmail(patient_email));
	}
	
	@GetMapping("/get/{doctorEmail}")
	public ResponseEntity<List<Appointment>> getAppointmentByDoctorEmail(@PathVariable("doctorEmail") String doctorEmail) {

		return ResponseEntity.ok(this.appointmentService.getAppointmentByDoctorEmail(doctorEmail));
	}

	@DeleteMapping("/{id}")
	public void deleteDoctor(@PathVariable("id") int id) {
		this.appointmentService.deleteAppointment(id);
	}
	
	
	  @PutMapping("/update-status/{id}")
	    public ResponseEntity<Appointment> updateAppointmentStatus(@PathVariable int id) {
		  
		  Appointment local = appointmentRepo.findById(id);
		  
		  String body ="Dear " + local.getPatient_firstName() +" "+ local.getPatient_lastName()+ ",\n\n" +
		            "Your appointment with Dr. " + local.getDr_name() + " on " + local.getAppointment_date() +
		            " has been approved by the doctor.\n\n" +
		            "Thank you for choosing our services.\n\n" +
		            "Best regards,\n" +
		            "Health Care System";

			emailService.sendEmail(local.getEmail(), "Appointment Approved", body);
	        
	        return ResponseEntity.ok(appointmentService.updateAppointmentStatus(id));
	    }
	  
	  @PutMapping("/reject-appointment/{id}")
	    public ResponseEntity<Appointment> rejectAppointmentStatus(@PathVariable int id) {
		  
       Appointment local = appointmentRepo.findById(id);
		  
		  String body ="Dear " + local.getPatient_firstName()+" "+local.getPatient_lastName()+ ",\n\n" +
		            "Your appointment with Dr. " + local.getDr_name() + " on " + local.getAppointment_date() +
		            " has been rejected by the doctor.\n\n" +
		            "Thank you for choosing our services.\n\n" +
		            "Best regards,\n" +
		            "Health Care System";

			emailService.sendEmail(local.getEmail(), "Appointment Rejected", body);
		  
	        return ResponseEntity.ok(appointmentService.rejectAppointment(id));
	    }
	  
	
}
