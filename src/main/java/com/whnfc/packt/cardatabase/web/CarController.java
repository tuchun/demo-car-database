package com.whnfc.packt.cardatabase.web;

import com.whnfc.packt.cardatabase.domain.Car;
import com.whnfc.packt.cardatabase.domain.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tuchun
 * @version 2019-12-16
 */
@RestController
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @RequestMapping("/cars")
    public Iterable<Car> getCars(){
        return carRepository.findAll();
    }
}
