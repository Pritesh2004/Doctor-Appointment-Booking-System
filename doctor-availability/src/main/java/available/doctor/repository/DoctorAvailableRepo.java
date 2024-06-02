package available.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import available.doctor.model.DoctorDetails;

public interface DoctorAvailableRepo extends JpaRepository<DoctorDetails, Long>{
	
	public DoctorDetails findByEmail(String dr_email);


}
