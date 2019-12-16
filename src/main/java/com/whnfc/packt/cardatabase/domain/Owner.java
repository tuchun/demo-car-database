package com.whnfc.packt.cardatabase.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @author tuchun
 * @version 2019-12-13
 */
@Entity
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = 20,nullable = false)
    private String firstname;

    @Column(length = 20,nullable = false)
    private String lastname;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "owner")
    private List<Car> cars;

    public Owner(String firstname, String lastname) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
