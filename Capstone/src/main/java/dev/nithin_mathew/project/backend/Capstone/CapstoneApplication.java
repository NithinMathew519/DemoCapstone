package dev.nithin_mathew.project.backend.Capstone;

//import dev.nithin_mathew.project.backend.Capstone.productService.inheritancerelations.mappedsuperclass.Mentor;
//import dev.nithin_mathew.project.backend.Capstone.productService.inheritancerelations.mappedsuperclass.MentorRepository;
//import dev.nithin_mathew.project.backend.Capstone.productService.inheritancerelations.tableperclass.*;
import dev.nithin_mathew.project.backend.Capstone.productService.models.Category;
import dev.nithin_mathew.project.backend.Capstone.productService.models.Price;
import dev.nithin_mathew.project.backend.Capstone.productService.models.Product;
import dev.nithin_mathew.project.backend.Capstone.productService.repositories.CategoryRepository;
import dev.nithin_mathew.project.backend.Capstone.productService.repositories.PriceRepository;
import dev.nithin_mathew.project.backend.Capstone.productService.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Transactional
@SpringBootApplication
public class CapstoneApplication implements CommandLineRunner {

	private final CategoryRepository catogoryRepository;
	private final ProductRepository productRepository;
	private final PriceRepository priceRepository;

    public CapstoneApplication(CategoryRepository catogoryRepository,
                               ProductRepository productRepository,
                               PriceRepository priceRepository, PriceRepository priceRepository1)
							    								{
		this.catogoryRepository = catogoryRepository;
		this.productRepository = productRepository;
		this.priceRepository = priceRepository;
                                                                }

//	private MentorRepository mentorRepository;
//	private StudentRepository studentRepository;
//	private UserRepository userRepository;
//	private TaRepository taRepository;
//	CapstoneApplication(@Qualifier("st_mentorrepository") MentorRepository mentorRepository,
//						@Qualifier("st_studentrepository") StudentRepository studentRepository,
//						@Qualifier("st_userrepository") UserRepository userRepository,
//						@Qualifier("st_tarepository") TaRepository taRepository) {
//		this.mentorRepository = mentorRepository;
//		this.studentRepository = studentRepository;
//		this.userRepository = userRepository;
//		this.taRepository = taRepository;
//	}

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

//		User user = new User();
//		user.setName("Nithin");
//		user.setEmail("nithinmathew123@gmail.com");
//		userRepository.save(user);
//
//		Mentor mentor = new Mentor();
//		mentor.setName("Nishanth");
//		mentor.setAvg_rating(4.8);
//		mentor.setEmail("nishanth@456@gmail.com");
//		mentorRepository.save(mentor);
//
//		Student student = new Student();
//		student.setName("Nishanth");
//		student.setPsp(99.0);
//		student.setEmail("Nikhil789@gmail.com");
//		studentRepository.save(student);
//
//		Ta ta = new Ta();
//		ta.setTa_session("Any Time");
//		taRepository.save(ta);
//		Category catogory = new Category();
//		catogory.setName("Apple Devices");
//
//		Category savedCategory =catogoryRepository.save(catogory);

//		Optional<Category> Optionalcategory=catogoryRepository.findById(UUID.fromString("aa636c78-025b-4d88-9b46-37349419730d"));
//		if (Optionalcategory.isEmpty()) {
//			System.out.println("Category not found");
//		}
//		Category category=Optionalcategory.get();
//		Product product = new Product();
//		product.setTitle("iPhone 15 Pro Max");
//		product.setDescription("The iPhone 15 Pro Max is the latest iPhone, introduced in September 2022. It comes with a six-inch display and a 6.7-megapixel camera.");
//		product.setCategory(category.get());
//		Product SavedProduct= productRepository.save(product);

//		List<Product> products = category.getProducts();
//		for (Product p : products) {
//			System.out.println(p.getTitle());
//		}

//		Price price = new Price();
//		price.setCurrency("INR");
//		price.setValue(90000.0);
//		Price savedPrice=priceRepository.save(price);


//		Category category = new Category();
//		category.setName("Apple Devices");
//		Category savedCategory= catogoryRepository.save(category);
//
//
//        Price price = new Price();
//        price.setValue(100000);
//        price.setCurrency("INR");
//
//        Product product1 = new Product();
//        product1.setPrice(price);
//        product1.setTitle("iPhone 15 pro max");
//        product1.setDescription("Best iPhone ever.");
//        product1.setImage("IMG");
//        product1.setCategory(category);
//        Product savedProduct = productRepository.save(product1);
//
//
//        Price price1 = new Price();
//        price1.setValue(100000);
//        price1.setCurrency("INR");
//
//
//        Product product2 = new Product();
//        product2.setPrice(price1);
//        product2.setTitle("iPhone 15 pro max");
//        product2.setDescription("Best iPhone ever.");
//        product2.setImage("IMG");
//        product2.setCategory(category);
//        Product savedProduct1 = productRepository.save(product2);
//
//        Price price2 = new Price();
//        price2.setValue(100000);
//        price2.setCurrency("INR");
//
//
//        Product product3 = new Product();
//        product3.setPrice(price2);
//        product3.setTitle("iPhone 15 pro max");
//        product3.setDescription("Best iPhone ever.");
//        product3.setImage("IMG");
//        product3.setCategory(category);
//        Product savedProduct2 = productRepository.save(product3);

		Optional<Category> categoryOptional= catogoryRepository.findById(UUID.fromString("54933799-1ff0-4a92-b08e-438d84ff87af"));

		Category category = categoryOptional.get();
		List<Product> products = category.getProducts();
		for (Product product : products) {
			System.out.println(product.getTitle());
		}
	}
}
