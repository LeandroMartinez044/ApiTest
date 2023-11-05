package com.martinez.customers.infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import app.swagger.api.CustomerApi;
import app.swagger.model.CustomerDto;

import com.martinez.customers.application.CustomerCreator;
import com.martinez.customers.application.CustomerSearcher;
import com.martinez.customers.domain.Customer;

@RestController
public class CustomerApiController implements CustomerApi {

    private CustomerCreator customerCreator;
    private CustomerSearcher customerSearcher;

    public CustomerApiController(
            final CustomerCreator theCustomerCreator,
            final CustomerSearcher theCustomerSearcher) {
        customerCreator = theCustomerCreator;
        customerSearcher = theCustomerSearcher;
    }

    @Override
    public ResponseEntity<Void> createCustomer(CustomerDto customer) {
        try {
            customerCreator.create(customer.getName(), customer.getLastName(), customer.getEmail());
        } catch (RuntimeException r) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, r.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<CustomerDto> getCustomer(Integer customerId) {
        Customer customer;
        CustomerDto customerDto = new CustomerDto();

        try {
            customer = customerSearcher.findById(customerId);
            customerDto.setName(customer.getFirstName());
            customerDto.setLastName(customer.getLastName());
            customerDto.setEmail(customer.getEmail());
        } catch (RuntimeException r) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, r.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
        }

        return ResponseEntity.ok(customerDto);
    }
}
