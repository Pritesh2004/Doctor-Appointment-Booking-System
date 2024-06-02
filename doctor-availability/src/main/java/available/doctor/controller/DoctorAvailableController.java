package available.doctor.controller;

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

import available.doctor.model.DoctorDetails;
import available.doctor.service.DoctorAvailableService;

@RestController
@RequestMapping("/doctorAvailable")
@CrossOrigin(origins = "*")
public class DoctorAvailableController {

	@Autowired
	private DoctorAvailableService doctorAvailableService;
	
	@PostMapping("/")
	public ResponseEntity<DoctorDetails> addDoctorAvailability(@RequestBody DoctorDetails doctor) throws Exception {

		
		DoctorDetails newDoctor = this.doctorAvailableService.addDoctorDetails(doctor);
		return new ResponseEntity<>(newDoctor, HttpStatus.CREATED);

	}

	@GetMapping("/{email}")
	public ResponseEntity<DoctorDetails> getDoctor(@PathVariable("email") String email) {

		return ResponseEntity.ok(this.doctorAvailableService.getDoctor(email));
	}

	@DeleteMapping("/{id}")
	public void deleteDoctor(@PathVariable("id") long id) {
		this.doctorAvailableService.deleteDoctor(id);
	}
	
}
