package com.tirmizee.repositories;

import com.tirmizee.entities.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    Optional<Customer> findByCid(String cid);

    List<Customer> findByFirstname(String firstname);

    List<Customer> findByLastname(String lastname);

}
