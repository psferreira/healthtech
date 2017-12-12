package com.br.healthtech.sandbox.spring.cloud.microservices.customer.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.br.healthtech.sandbox.spring.cloud.microservices.account.model.Account;
import com.br.healthtech.sandbox.spring.cloud.microservices.customer.model.Customer;
import com.br.healthtech.sandbox.spring.cloud.microservices.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.br.healthtech.sandbox.spring.cloud.microservices.customer.intercomm.AccountClient;

@RestController
public class Api {
	
	@Autowired
	private AccountClient accountClient;

	@Autowired
	private CustomerRepository customerRepository;

	protected Logger logger = Logger.getLogger(Api.class.getName());
	
	public Api() {
	}

	@RequestMapping("/customers")
	public List<Customer> findAll() {
		logger.info("Customer.findAll()");
		final List<Customer> customers= new ArrayList<>();
		customerRepository.findAll().forEach(customers::add);
		return customers;
	}
	
	@RequestMapping("/customers/accounts/{id}")
	public Customer findByAccountId(@PathVariable("id") final Integer id) {
		logger.info(String.format("Customer.findByAccountId(%s)", id));
		final List<Customer> customers = findAll();
		final Customer customer = customers.stream().filter(it -> it.getId().intValue()==id.intValue()).findFirst().get();
		final Account account =  accountClient.getAccount(id);
		customer.setAccount(account);
		return customer;
	}

	@RequestMapping("/customers/{id}")
	public Customer findById(@PathVariable("id") final Long id) {
		logger.info(String.format("Customer.findById(%s)", id));
		return customerRepository.findOne(id);
	}

	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public Customer add(@RequestBody final Customer customer) {
		logger.info(String.format("Customer.add(%s)", customer));
		return customerRepository.save(customer);
	}
}
