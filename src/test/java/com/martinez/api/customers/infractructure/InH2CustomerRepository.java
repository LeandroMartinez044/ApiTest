package com.martinez.api.customers.infractructure;

import com.martinez.api.TestApplication;
import com.martinez.customers.domain.Customer;
import com.martinez.customers.domain.CustomerRepository;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public final class InH2CustomerRepository {

    private static ConfigurableApplicationContext application;

    private CustomerRepository inH2CustomerRepository;

    private Customer customer;

    @BeforeClass
    public static void prepare(){
        application = TestApplication.start();
    }

    @AfterClass
    public static void finish() {
        if (application != null) {
            application.stop();
        }
    }

    @Before
    public void setup(){
        customer = new Customer("Leandro", "Martinez", "martinezleandro044@gmaiil.com");
        inH2CustomerRepository = application.getBean("inH2CustomerRepository", CustomerRepository.class);
    }

    @Test
    public void save_ok() {
        inH2CustomerRepository.save(customer);
        Customer foundCustomer = inH2CustomerRepository.findById(customer.getId());
        assertThat(customer.getFirstName(), is(foundCustomer.getFirstName()));
        assertThat(customer.getLastName(), is(foundCustomer.getLastName()));
        assertThat(customer.getEmail(), is(foundCustomer.getEmail()));
    }

    @Test
    public void findById_ok() {
        inH2CustomerRepository.save(customer);
        Customer foundCustomer = inH2CustomerRepository.findById(customer.getId());
        assertThat(customer.getFirstName(), is(foundCustomer.getFirstName()));
        assertThat(customer.getLastName(), is(foundCustomer.getLastName()));
        assertThat(customer.getEmail(), is(foundCustomer.getEmail()));
    }

}
