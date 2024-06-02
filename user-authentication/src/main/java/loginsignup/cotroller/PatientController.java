package loginsignup.cotroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import loginsignup.model.Patient;
import loginsignup.model.PatientLogin;
import loginsignup.model.UserQuery;
import loginsignup.repo.PatientRepo;
import loginsignup.service.EmailSenderService;
import loginsignup.service.PatientService;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins="*")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private PatientRepo patientRepo;
	
	@Autowired
	private EmailSenderService emailService;
	
	public PatientController(PatientService patientService) {
		this.patientService=patientService;
	}
	
	
	@PostMapping("/")
	public ResponseEntity<Patient>  createPatient(@RequestBody Patient patient) throws Exception {
		
		Patient newPatient=this.patientService.createPatient(patient);
		return new ResponseEntity<>(newPatient,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<Patient> getUser(@PathVariable("email") String email) {
		
		return ResponseEntity.ok(this.patientService.getPatient(email));
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		this.patientService.deletePatient(id);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Patient> login(@RequestBody PatientLogin login) throws Exception {
		
		Patient local=this.patientRepo.findByEmail(login.getEmail());
		
		if (login.getEmail().equals(local.getEmail()) && login.getPassword().equals(local.getPassword())) {
			System.out.print("Authentication successfull");
			return new ResponseEntity<>(local, HttpStatus.ACCEPTED);
        }else {
        	System.out.print("Patient Not Present Authentication Failed!");
        	return null; 
        }
		
	}
	
//	@PostMapping("/query")
//	public ResponseEntity<UserQuery> postQueries(@RequestBody UserQuery userQuery) throws Exception{
//		
//		String emailBody ="Your Query Has Been Successfully Saved! "+"\n\n" +
//	            "We appreciate your interest in our services and will be in touch with you shortly. " + "\n\n"+
//	            "Thank you for choosing our advanced Health Care System..\n\n" +
//	            "Best regards,\n" +
//	            "Health Care System";
//
//		emailService.sendEmail(userQuery.getEmail(), "Health Care System", emailBody);
//		
//		UserQuery newQuery=this.patientService.postQuery(userQuery);
//		return new ResponseEntity<>(newQuery, HttpStatus.CREATED);
//	}

}
