package available.doctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import available.doctor.model.DoctorDetails;
import available.doctor.repository.DoctorAvailableRepo;

@Service
public class DoctorAvailableServiceImpl implements DoctorAvailableService {

	@Autowired
	private DoctorAvailableRepo doctorAvailableRepo;
	
	@Override
	public DoctorDetails addDoctorDetails(DoctorDetails doctor) throws Exception {
		// TODO Auto-generated method stub
		DoctorDetails local = this.doctorAvailableRepo.findByEmail(doctor.getEmail());

		if (local != null) {
			System.out.println("Doctor already present");
			throw new Exception("Doctor already present");
		} else {

			doctor = this.doctorAvailableRepo.save(doctor);
			System.out.println(local);
		}

		return doctor;
	}

	@Override
	public DoctorDetails getDoctor(String dr_email) {
		// TODO Auto-generated method stub
		return this.doctorAvailableRepo.findByEmail(dr_email);
	}

	@Override
	public void deleteDoctor(Long dr_id) {
		// TODO Auto-generated method stub
		this.doctorAvailableRepo.deleteById(dr_id);

	}

}
