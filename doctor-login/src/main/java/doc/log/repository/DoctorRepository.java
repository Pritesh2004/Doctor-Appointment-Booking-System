package doc.log.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import doc.log.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

	public Doctor findByEmail(String email);

}
