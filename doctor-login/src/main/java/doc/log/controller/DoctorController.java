package doc.log.controller;

import java.util.List;

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

import doc.log.model.Doctor;
import doc.log.model.LoginRequest;
import doc.log.repository.DoctorRepository;
import doc.log.service.DoctorService;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = "*")
public class DoctorController {

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	public DoctorRepository doctorRepository;

	@PostMapping("/")
	public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) throws Exception {

		Doctor newDoctor = this.doctorService.createDoctor(doctor);
		return new ResponseEntity<>(newDoctor, HttpStatus.CREATED);

	}
	
	@GetMapping("/getAll")
	public List<Doctor> getAllDoctors(){
		return this.doctorService.getAllDoctors();
	}

	@GetMapping("/{email}")
	public ResponseEntity<Doctor> getDoctor(@PathVariable("email") String email) {

		return ResponseEntity.ok(this.doctorService.getDoctor(email));
	}

	@DeleteMapping("/{id}")
	public void deleteDoctor(@PathVariable("id") long id) {
		this.doctorService.deleteDoctor(id);
	}

	@PostMapping("/login")
	public ResponseEntity<Doctor> login(@RequestBody LoginRequest loginRequest) throws Exception {
		
		Doctor local=this.doctorRepository.findByEmail(loginRequest.getEmail());
		
		if (loginRequest.getEmail().equals(local.getEmail()) && loginRequest.getPassword().equals(local.getPassword())) {
			return new ResponseEntity<>(local, HttpStatus.CREATED);
        }else {
        	System.out.print("Doctor Not Present Authentication Failed!");
        	return null; 
        }
		
	}

}
