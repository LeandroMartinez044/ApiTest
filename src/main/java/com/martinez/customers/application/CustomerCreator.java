package com.martinez.customers.application;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.martinez.customers.domain.Customer;
import com.martinez.customers.domain.CustomerRepository;
import com.martinez.utils.Validate;

/** The customer creator for customer.
 */
@Service
public class CustomerCreator {

    /** The customer repository, never null.
     */
    private CustomerRepository customerRepository;

    /** Constructor.
     *
     * @param theCustomerRepository the customer repository. It cannot be null.
     */
    public CustomerCreator(
            @Qualifier("InH2CustomerRepository") final CustomerRepository theCustomerRepository) {
        Validate.notNull(theCustomerRepository, "the customer repository cannot be null");
        customerRepository = theCustomerRepository;
    }

    /**
     * Create a new Customer.
     *
     * @param theFirstName represents the customer name. Cannot be blank.
     *
     * @param theLastName represents the customer last name. Cannot be blank.
     *
     * @param theEmail represents the customer email. Cannot be blank.
     */
    public void create(final String theFirstName, final String theLastName,
                       final String theEmail) {
        Validate.notBlank(theFirstName, "customer name cannot be blank");
        Validate.notBlank(theLastName, "customer last name cannot be blank");
        Validate.notBlank(theEmail, "customer email cannot be blank");

        Customer customer = new Customer(theFirstName, theLastName, theEmail);
        customerRepository.save(customer);
    }
}
