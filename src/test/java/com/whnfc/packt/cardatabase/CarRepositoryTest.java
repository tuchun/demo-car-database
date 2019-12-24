package com.whnfc.packt.cardatabase;

import com.whnfc.packt.cardatabase.domain.Car;
import com.whnfc.packt.cardatabase.domain.CarRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
/**
 * @author tuchun
 * @version 2019-12-17
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void saveCar(){
        Car car = new Car("Tesla","Model X","White","ABC-1234",2017,86000);
        entityManager.persistAndFlush(car);

        Assertions.assertThat(car.getId()).isNotNull();
    }

    @Test
    public void deleteCars(){
        Car car1 = new Car("Tesla","Model X-1","White","ABC-12341",2017,86000);
        Car car2 = new Car("Tesla","Model X-2","White","ABC-12342",2017,86000);

        entityManager.persistAndFlush(car1);
        entityManager.persistAndFlush(car2);

        carRepository.deleteAll();

        Assertions.assertThat(carRepository.findAll()).isEmpty();
    }

}
