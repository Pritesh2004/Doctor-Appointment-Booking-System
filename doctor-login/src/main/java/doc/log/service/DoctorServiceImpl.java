package doc.log.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import doc.log.model.Doctor;
import doc.log.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	public DoctorRepository doctorRepository;

	@Override
	public Doctor createDoctor(Doctor doctor) throws Exception {
		// TODO Auto-generated method stub
		Doctor local = this.doctorRepository.findByEmail(doctor.getEmail());

		if (local != null) {
			System.out.println("Doctor already present");
			throw new Exception("Doctor already present");
		} else {

			doctor = this.doctorRepository.save(doctor);
			System.out.println(local);
		}

		return doctor;
	}

	@Override
	public Doctor getDoctor(String email) {
		// TODO Auto-generated method stub
		return this.doctorRepository.findByEmail(email);

	}

	@Override
	public void deleteDoctor(Long id) {
		// TODO Auto-generated method stub
		this.doctorRepository.deleteById(id);

	}

//	@Override
//	public Doctor loginDoctor(String email, String password) throws Exception {
//		
//		  Doctor doctor = doctorRepository.findByEmail(email);
//	        if (doctor != null && doctor.getPassword()==password && doctor.getEmail()==email) {
//	        	System.out.print(doctor);
//	            return doctor;
//	        }
//	        else {
//	        	System.out.println("Doctor not present");
//				throw new Exception("Doctor not present");
//	        }
//	        
//	}

	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		
		return this.doctorRepository.findAll(); 
	}

}
