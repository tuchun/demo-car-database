package com.whnfc.packt.cardatabase;

import com.whnfc.packt.cardatabase.domain.Car;
import com.whnfc.packt.cardatabase.domain.CarRepository;
import com.whnfc.packt.cardatabase.domain.Owner;
import com.whnfc.packt.cardatabase.domain.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CardatabaseApplication {

    private static final Logger log = LoggerFactory.getLogger(CardatabaseApplication.class);

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerRepository ownerRepository;

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

        };
    }

}
