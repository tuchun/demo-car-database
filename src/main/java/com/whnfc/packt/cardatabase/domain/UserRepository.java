package com.whnfc.packt.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author tuchun
 * @version 2019-12-16
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    public User findByUsername(String username);
}
