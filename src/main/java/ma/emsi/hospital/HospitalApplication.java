package ma.emsi.hospital;

import ma.emsi.hospital.entities.Patient;
import ma.emsi.hospital.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;


@SpringBootApplication
public class HospitalApplication implements CommandLineRunner {

    private final PatientRepository patientRepository;

    public HospitalApplication(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public static void main(String[] args) {SpringApplication.run(HospitalApplication.class, args);}

    @Override
    public void run(String... args) {
        patientRepository.save(new Patient(null,"Mohamed",new Date(),false,22));
        patientRepository.save(new Patient(null,"Amine",new Date(),false,52));
        patientRepository.save(new Patient(null,"Ali",new Date(),true,12));

        System.out.println("\nConsulter tous les patients");

        Page<Patient> patients = patientRepository.findAll(PageRequest.of(1,5));
        patients.forEach(p -> {
            System.out.println("==============================");
            System.out.println("Id                : " + p.getId());
            System.out.println("Name              : " + p.getName());
            System.out.println("Score             : " + p.getScore());
            System.out.println("Date de naissance : " + p.getDateNaissance());
            System.out.println("Malade            : " + p.isMalade());
        });
        System.out.println("**********************************");
        System.out.println("\nConsulter patient par Id : ");
        Patient patient = patientRepository.findById(1L).orElse(null);
        if (patient != null){
            System.out.println("==============================");
            System.out.println("Id                : " + patient.getId());
            System.out.println("Name              : " + patient.getName());
            System.out.println("Score             : " + patient.getScore());
            System.out.println("Date de naissance : " + patient.getDateNaissance());
            System.out.println("Malade            : " + patient.isMalade());
        }
        patientRepository.deleteById(1L);
        System.out.println("********* Patient deleted ! **********");
        patientRepository.save(new Patient(null,"Mohamed",new Date(),false,22));
        if (patient != null) {
            patient.setScore(99);
        patientRepository.save(patient);
        System.out.println("******* Updated patient *******");
        System.out.println("==============================");
        System.out.println("Id                : " + patient.getId());
        System.out.println("Name              : " + patient.getName());
        System.out.println("Score             : " + patient.getScore());
        System.out.println("Date de naissance : " + patient.getDateNaissance());
        System.out.println("Malade            : " + patient.isMalade());
        }


    }
}
