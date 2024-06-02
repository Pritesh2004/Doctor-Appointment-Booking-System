package loginsignup.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import loginsignup.model.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long> {
	
	public Patient findByEmail(String email);

}
