package doc.log.service;


import java.util.List;

import doc.log.model.Doctor;

public interface DoctorService {
	
//	Creating Doctor
	public Doctor createDoctor(Doctor doctor) throws Exception;
	
//	Getting Doctor using username
	public Doctor getDoctor(String email);
	
//	Deleting Doctor using id
	public void deleteDoctor(Long id);
	
//	public Doctor loginDoctor(String email, String password)throws Exception;
	
	public List<Doctor> getAllDoctors();

}
