package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Company;
import com.example.demo.entities.Item;
import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.CompanyRepository;
import com.example.demo.repositories.ItemRepository;

@SpringBootApplication
public class CrudBackendApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CrudBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//TEST User
		userRepository.save(new User("Boris","Zaharic","boris.zaharic@gmail.com","username","password","IT engine","Developer"));
		userRepository.save(new User("Milos","Pavlovic","milos.pavlovic@gmail.com","milos","password2","IT engine","Developer"));
		userRepository.save(new User("Milica","Pavlovic","milica.pavlovic@gmail.com","milica","password3","IT engine","QA"));
		
		//TEST Company
		companyRepository.save(new Company("one","one","one","one"));
		companyRepository.save(new Company("two","one","two","one"));
		companyRepository.save(new Company("three","one","two","one"));
		
		//TEST 
		itemRepository.save(new Item("one","one","one","one","one",121324));
		itemRepository.save(new Item("two","one","two","one","one",121324));
		itemRepository.save(new Item("three","one","two","one","one",121324));
		
	}
}