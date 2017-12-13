package br.com.healthtech.sandbox.spring.cloud.microservices.customer.intercomm;

import br.com.healthtech.sandbox.spring.cloud.microservices.customer.model.Account;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("account-service")
public interface AccountClient {

    @RequestMapping(method = RequestMethod.GET, value = "/accounts/customer/{customerId}")
    Account getAccount(@PathVariable("customerId") Integer customerId);
    
}
