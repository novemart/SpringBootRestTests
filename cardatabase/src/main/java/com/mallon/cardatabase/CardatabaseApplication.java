package com.mallon.cardatabase;

import com.mallon.cardatabase.domain.dao.CarRepository;
import com.mallon.cardatabase.domain.dao.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardatabaseApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	
	@Autowired
	private CarRepository repository;
	
	@Autowired
	private OwnerRepository owner_repository;

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
//		auto restart test comment
		logger.info("Hello Spring Boot");
		
	}

//	@Bean
//	CommandLineRunner runner(){
//	return args -> {
//		// Save demo data to database
//		// Add owner objects and save these to the database
//		Owner owner1 = new Owner("Julie" , "Dooley");
//		Owner owner2 = new Owner("Bob" , "Robinson");
//		owner_repository.save(owner1);
//		owner_repository.save(owner2);
//
//		// Add cars with OWNERs
//		repository.save(new Car("Ford", "Focus", "Red",
//		"AB17 SWD", 2017, 59000,owner1 ));
//		repository.save(new Car("Audi", "TT", "White",
//		"DE14 VCL", 2014, 29000, owner1));
//		repository.save(new Car("BMW", "5 Series", "Silver",
//		"KK18 UYR", 2018, 39000, owner2));
//		};
//	}

	

}
