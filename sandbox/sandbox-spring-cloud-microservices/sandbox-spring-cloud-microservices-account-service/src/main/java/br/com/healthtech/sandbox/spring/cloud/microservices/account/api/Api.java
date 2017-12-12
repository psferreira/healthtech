package br.com.healthtech.sandbox.spring.cloud.microservices.account.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import br.com.healthtech.sandbox.spring.cloud.microservices.account.model.Account;
import br.com.healthtech.sandbox.spring.cloud.microservices.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Api {

	@Autowired
	private AccountRepository accountRepository;

	protected Logger logger = Logger.getLogger(Api.class.getName());


	public Api() {
	}
	
	@RequestMapping("/accounts/{id}")
	public Account findByNumber(@PathVariable("id") final Long id) {
		logger.info(String.format("Account.findById(%s)", id));
		return accountRepository.findOne(id);
	}

	@RequestMapping("/accounts")
	public List<Account> findAll() {
		logger.info("Account.findAll()");
		final List<Account> accounts= new ArrayList<>();
		accountRepository.findAll().forEach(accounts::add);
		return accounts;
	}

	@RequestMapping(value = "/accounts", method = RequestMethod.POST)
	public Account add(@RequestBody final Account account) {
		logger.info(String.format("Account.add(%s)", account));
		return accountRepository.save(account);
	}

	@RequestMapping(value = "/accounts/customer/{customer}", method = RequestMethod.GET)
	public Account findByCustomer(@PathVariable("customer") final Integer customerId) {
		logger.info(String.format("Account.findByCustomerId(%s)", customerId));
		return accountRepository.findByCustomerId(customerId);
	}
}
