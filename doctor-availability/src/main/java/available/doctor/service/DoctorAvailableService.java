package available.doctor.service;

import available.doctor.model.DoctorDetails;


public interface DoctorAvailableService {
	
//	Creating Doctor
	public DoctorDetails addDoctorDetails(DoctorDetails doctor) throws Exception;
	
//	Getting Doctor using Email
	public DoctorDetails getDoctor(String dr_email);
	
//	Deleting Doctor using id
	public void deleteDoctor(Long dr_id);

}
