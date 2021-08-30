package com.ksnote.jpastudy;

import com.ksnote.jpastudy.domain.demo.Customer;
import com.ksnote.jpastudy.domain.demo.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class JpaStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaStudyApplication.class);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
        return (args -> {
            repository.save(Customer.builder().firstName("Jack").lastName("Bauer").build());
            repository.save(Customer.builder().firstName("Chloe").lastName("O'Brian").build());
            repository.save(Customer.builder().firstName("Kim").lastName("Bauer").build());
            repository.save(Customer.builder().firstName("David").lastName("Palmer").build());
            repository.save(Customer.builder().firstName("Michelle").lastName("Dessler").build());

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (Customer customer : repository.findAll()) {
                log.info(customer.toString());
            }
        });
    }

}
