package com.martinez.api.customers.domain;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import com.martinez.customers.domain.Customer;

public final class CustomerTest {

    @Test
    public void new_ok() {
        Customer customer = new Customer("Leandro","Martinez", "a@gmail.com" );
        assertThat(customer.getFirstName(), is("Leandro"));
        assertThat(customer.getLastName(), is("Martinez"));
        assertThat(customer.getEmail(), is("a@gmail.com"));
    }
}
