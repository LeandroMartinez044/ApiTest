package com.martinez.api.customers.application;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.martinez.customers.application.CustomerCreator;
import com.martinez.customers.domain.Customer;
import com.martinez.customers.domain.CustomerRepository;

public final class CustomerCreatorTest {
    @Mock
    private CustomerRepository customerRepository;

    private CustomerCreator customerCreator;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        customerCreator = new CustomerCreator(customerRepository);
    }

    @Test
    public void create_test_ok() {
        customerCreator.create("Leandro", "Martinez", "martinezleandro044@gmail.com");
        verify(customerRepository, times(1)).save(any(Customer.class));
    }
}
