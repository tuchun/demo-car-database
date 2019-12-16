package com.whnfc.packt.cardatabase.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author tuchun
 * @version 2019-12-13
 */
public interface CarRepository extends PagingAndSortingRepository<Car,Long> {

    public Car findByRegisterNumber(String registerNumber);

    @Query("select c from Car c where c.model = ?1")
    public Car findByM(String model);

}
