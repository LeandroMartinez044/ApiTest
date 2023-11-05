package com.martinez.api.customers.application;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.martinez.customers.application.CustomerSearcher;
import com.martinez.customers.domain.Customer;
import com.martinez.customers.domain.CustomerRepository;

public final class CustomerSearcherTest {

    @Mock
    private CustomerRepository customerRepository;

    private CustomerSearcher customerSearcher;

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);
        customerSearcher = new CustomerSearcher(customerRepository);
    }

    @Test
    public void findById_ok() {
        Customer customer = new Customer("Leandro", "Martinez",
        "martinezleandro044@gmail.com");
        ReflectionTestUtils.setField(customer, "id", 1);

        when(customerRepository.findById(1)).thenReturn(customer);

        Customer customerFound = customerSearcher.findById(1);

        assertThat(customerFound.getFirstName(), is("Leandro"));
        assertThat(customerFound.getLastName(), is("Martinez"));
        assertThat(customerFound.getEmail(), is("martinezleandro044@gmail.com"));

        verify(customerRepository, times(1)).findById(1);
    }
}
