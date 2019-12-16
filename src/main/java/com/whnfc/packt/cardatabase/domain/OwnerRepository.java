package com.whnfc.packt.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author tuchun
 * @version 2019-12-13
 */
@Repository
public interface OwnerRepository extends CrudRepository<Owner,Long> {

}
