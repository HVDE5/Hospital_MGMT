package ma.emsi.hospital;

import ma.emsi.hospital.entities.Patient;
import ma.emsi.hospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;

@SpringBootApplication
public class HospitalApplication implements CommandLineRunner {

	@Autowired
	private PatientRepository patientRepository;
	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}

	@Override
	public void run(String... args) {
		patientRepository.save(new Patient(null,"Mohamed",new Date(),false,22));
		patientRepository.save(new Patient(null,"Amine",new Date(),false,52));
		patientRepository.save(new Patient(null,"Ali",new Date(),true,12));

		Page<Patient> patients = patientRepository.findAll(PageRequest.of(1, 5));
		patients.forEach(patient -> System.out.println(patient.toString()));
	}
}
