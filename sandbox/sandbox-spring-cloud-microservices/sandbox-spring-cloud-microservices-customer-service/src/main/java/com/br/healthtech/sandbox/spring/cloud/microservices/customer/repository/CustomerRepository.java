package com.br.healthtech.sandbox.spring.cloud.microservices.customer.repository;

import com.br.healthtech.sandbox.spring.cloud.microservices.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
