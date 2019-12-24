package com.whnfc.packt.cardatabase.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author tuchun
 * @version 2019-12-13
 */
@RepositoryRestResource
public interface CarRepository extends PagingAndSortingRepository<Car,Long> {

    public Car findByRegisterNumber(@Param("registerNumber") String registerNumber);

    @Query("select c from Car c where c.model = ?1")
    public Car findByM(@Param("model") String model);

}
