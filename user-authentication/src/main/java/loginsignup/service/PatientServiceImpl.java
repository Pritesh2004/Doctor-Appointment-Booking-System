package loginsignup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import loginsignup.model.Patient;
import loginsignup.model.UserQuery;
import loginsignup.repo.PatientRepo;
import loginsignup.repo.UserQueryRepo;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	private PatientRepo patientRepo;
	
	@Autowired
	private UserQueryRepo queryRepo;

	@Override
	public Patient createPatient(Patient patient) throws Exception {
		
		Patient local=this.patientRepo.findByEmail(patient.getEmail());
		
		if(local!=null) {
			System.out.println("Patient already present");
			throw new Exception("Patient already present");
		}else {
			
			patient=this.patientRepo.save(patient);
			System.out.println(local);
		}
		
		return patient;
	}

	@Override
	public Patient getPatient(String email) {
		// TODO Auto-generated method stub
		Patient local = patientRepo.findByEmail(email);
		return local;
	}

	@Override
	public void deletePatient(Long id) {
		// TODO Auto-generated method stub
		patientRepo.deleteById(id);
	}

	@Override
	public UserQuery postQuery(UserQuery userQuery) throws Exception {
		// TODO Auto-generated method stub
		UserQuery query = this.queryRepo.save(userQuery);
		return query;
	}

	

}
