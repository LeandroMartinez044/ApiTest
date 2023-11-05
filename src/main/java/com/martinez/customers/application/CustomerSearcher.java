package com.martinez.customers.application;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.martinez.customers.domain.Customer;
import com.martinez.customers.domain.CustomerRepository;
import com.martinez.utils.Validate;

/** The customer searcher for customer.
 */
@Service
public class CustomerSearcher {

    /** The customer repository, never null.
     */
    private CustomerRepository customerRepository;

    /** Constructor.
     *
     * @param theCustomerRepository the customer repository. It cannot be null.
     */
    public CustomerSearcher(
            @Qualifier("InH2CustomerRepository") final CustomerRepository theCustomerRepository) {
        Validate.notNull(theCustomerRepository, "the customer repository cannot be null");
        customerRepository = theCustomerRepository;
    }

    /** Find a customer by customer id.
     *
     * @param customerId the customer id. It cannot be null.
     *
     * @return a Customer, could be null if not found a customer.
     */
    public Customer findById(Integer customerId) {
        Validate.notNull(customerId, "customerId cannot be null.");
        return customerRepository.findById(customerId);
    }
}
