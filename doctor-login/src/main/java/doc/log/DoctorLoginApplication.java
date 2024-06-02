package doc.log;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import doc.log.model.Doctor;
import doc.log.repository.DoctorRepository;
import doc.log.service.DoctorService;

@SpringBootApplication
public class DoctorLoginApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DoctorLoginApplication.class, args);
	}

//	Random random = new Random();
//
//	@Autowired
//	private DoctorService doctorService;

	@Override
	public void run(String... args) throws Exception {
		
//		Doctor doctor = new Doctor();
//
//		doctor.setUsername("pritesh123");
//		doctor.setEmail("pritesh100@gmail.com");
//		doctor.setPassword("pritesh123");
//		doctor.setFirstName("Pritesh");
//		doctor.setLastName("Patil");
//		doctor.setSpeciality("Surgeon");
//		doctor.setPhone("9820465120");
//
//		doctor = this.doctorService.createDoctor(doctor);
//
//		System.out.println(doctor);

	}

}
