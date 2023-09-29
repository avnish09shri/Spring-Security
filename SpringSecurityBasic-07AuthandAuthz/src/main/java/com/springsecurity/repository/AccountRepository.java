package com.springsecurity.repository;

import com.springsecurity.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
	
	Optional<Account> findByCustomerId(int customerId);

}
