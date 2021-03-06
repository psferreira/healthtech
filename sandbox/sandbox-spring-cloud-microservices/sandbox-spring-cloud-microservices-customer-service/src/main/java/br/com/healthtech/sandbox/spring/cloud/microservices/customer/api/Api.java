package br.com.healthtech.sandbox.spring.cloud.microservices.customer.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import br.com.healthtech.sandbox.spring.cloud.microservices.customer.intercomm.AccountClient;
import br.com.healthtech.sandbox.spring.cloud.microservices.customer.model.Account;
import br.com.healthtech.sandbox.spring.cloud.microservices.customer.model.Customer;
import br.com.healthtech.sandbox.spring.cloud.microservices.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public Account findByAccountId(@PathVariable("id") final Integer id) {
		logger.info(String.format("Customer.findByAccountId(%s)", id));
		return accountClient.getAccount(id);
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
