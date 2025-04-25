package dev.nithin_mathew.project.backend.Capstone;

//import dev.nithin_mathew.project.backend.Capstone.productService.inheritancerelations.mappedsuperclass.Mentor;
//import dev.nithin_mathew.project.backend.Capstone.productService.inheritancerelations.mappedsuperclass.MentorRepository;
import dev.nithin_mathew.project.backend.Capstone.productService.inheritancerelations.singletable.*;
//import dev.nithin_mathew.project.backend.Capstone.productService.inheritancerelations.tableperclass.*;
import dev.nithin_mathew.project.backend.Capstone.productService.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CapstoneApplication implements CommandLineRunner {
//public class CapstoneApplication implements CommandLineRunner {
	private MentorRepository mentorRepository;
	private StudentRepository studentRepository;
	private UserRepository userRepository;
	private TaRepository taRepository;
	CapstoneApplication(@Qualifier("st_mentorrepository") MentorRepository mentorRepository,
						@Qualifier("st_studentrepository") StudentRepository studentRepository,
						@Qualifier("st_userrepository") UserRepository userRepository,
						@Qualifier("st_tarepository") TaRepository taRepository) {
		this.mentorRepository = mentorRepository;
		this.studentRepository = studentRepository;
		this.userRepository = userRepository;
		this.taRepository = taRepository;
	}
//	ms_mentorrepository
//	tpc_mentorrepository
//	CapstoneApplication(@Qualifier("tpc_mentorrepository")
//						MentorRepository mentorRepository,
//						StudentRepository studentRepository,
//						UserRepository userRepository) {
//		this.mentorRepository = mentorRepository;
//		this.studentRepository = studentRepository;
//		this.userRepository = userRepository;
//	}
	public static void main(String[] args) {
		SpringApplication.run(CapstoneApplication.class, args);
	}
	public void run(String... args) throws Exception {
//		Mentor mentor = new Mentor();
//		mentor.setName("Nithin");
//		mentor.setEmail("nithinmathew519@gmail.com");
//		mentor.setAvg_rating(8.0);
//		mentorRepository.save(mentor);
//
//		Student student = new Student();
//		student.setName("Nishanth");
//		student.setEmail("nishnath@519Prabhu");
//		student.setPsp(90.0);
//		studentRepository.save(student);
//
//		User user = new User();
//		user.setName("Nikhil");
//		user.setEmail("nikhil@519Prabhu");
//		userRepository.save(user);
//
//		List<User> Users = (List<User>) userRepository.findAll();
//			for (User u : Users) {
//				System.out.println(u.toString());
//			}
		User user = new User();
		user.setName("Nithin");
		user.setEmail("nithinmathew123@gmail.com");
		userRepository.save(user);

		Mentor mentor = new Mentor();
		mentor.setName("Nishanth");
		mentor.setAvg_rating(4.8);
		mentor.setEmail("nishanth@456@gmail.com");
		mentorRepository.save(mentor);

		Student student = new Student();
		student.setName("Nishanth");
		student.setPsp(99.0);
		student.setEmail("Nikhil789@gmail.com");
		studentRepository.save(student);

		Ta ta = new Ta();
		ta.setTa_session("Any Time");
		taRepository.save(ta);
	}

}
