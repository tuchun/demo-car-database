package com.whnfc.packt.cardatabase;

import com.whnfc.packt.cardatabase.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CardatabaseApplication extends SpringBootServletInitializer {

    private static final Logger log = LoggerFactory.getLogger(CardatabaseApplication.class);

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CardatabaseApplication.class);
    }

    public static void main(String[] args) {
        log.info("My Application start...");
        SpringApplication.run(CardatabaseApplication.class, args);
    }

    @Bean
    public CommandLineRunner ruanner() {
        return args -> {
            Owner owner1 = new Owner("CHUN", "TU");
            Owner owner2 = new Owner("ZIQIAN", "TU");

            ownerRepository.save(owner1);
            ownerRepository.save(owner2);

            Car car1 = new Car("Ford", "Mustang", "Red",
                    "ADF-1121", 2017, 59000, owner1);
            carRepository.save(car1);

            Car car2 = new Car("Nissan", "Leaf", "White",
                    "SSJ-3002", 2014, 29000, owner2);
            carRepository.save(car2);

            Car car3 = new Car("Toyota", "Prius", "Silver",
                    "KKO-0212", 2018, 39000, owner2);
            carRepository.save(car3);

            User user1 = new User("user","$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi","USER");
            User user2 = new User("admin","$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG","ADMIN");

            userRepository.save(user1);
            userRepository.save(user2);
        };
    }

}
