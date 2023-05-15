package com.jewelry.jew;

import com.jewelry.jew.entity.Jewelry;
import com.jewelry.jew.repository.JewelryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class JewApplication {

	public static void main(String[] args) {
		SpringApplication.run(JewApplication.class, args);
	}

//	@Bean
//	CommandLineRunner init(JewelryRepository jewelryRepository) {
//		return args -> {
//			List<Jewelry> jewelries = (List<Jewelry>) jewelryRepository.findAll();
//			System.out.println(jewelries.get(0));
//		};
//	}

}
