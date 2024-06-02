package loginsignup.service;



import loginsignup.model.Patient;
import loginsignup.model.UserQuery;

public interface PatientService {

//	Creating Patient
	public Patient createPatient(Patient patient) throws Exception;
	
//	Getting Patient using email
	public Patient getPatient(String email);
	
//	Deleting user using id
	public void deletePatient(Long id);
	
//	Post Queries
	public UserQuery postQuery(UserQuery userQuery) throws Exception;
	
}
