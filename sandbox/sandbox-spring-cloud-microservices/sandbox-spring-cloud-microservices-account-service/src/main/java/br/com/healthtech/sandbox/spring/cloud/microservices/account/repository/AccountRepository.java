package br.com.healthtech.sandbox.spring.cloud.microservices.account.repository;

import br.com.healthtech.sandbox.spring.cloud.microservices.account.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository  extends CrudRepository<Account, Long> {

    Account findByCustomerId(Integer customerId);
}
