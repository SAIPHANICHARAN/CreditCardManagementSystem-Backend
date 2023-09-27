package com.sunku.sg.creditcardms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sunku.sg.creditcardms.entity.CreditCardRequestEntity;


@Repository
public interface CrediCardRequestRepository extends CrudRepository<CreditCardRequestEntity, Integer>{

}
