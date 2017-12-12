package com.br.healthtech.sandbox.spring.cloud.microservices.account.repository;

import com.br.healthtech.sandbox.spring.cloud.microservices.account.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository  extends CrudRepository<Account, Long> {

    Account findByCustomerId(Integer customerId);
}
