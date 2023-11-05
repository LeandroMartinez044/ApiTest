package com.martinez.api.customers.infractructure;

import app.swagger.model.CustomerDto;
import com.martinez.customers.application.CustomerCreator;
import com.martinez.customers.application.CustomerSearcher;
import com.martinez.customers.domain.Customer;
import com.martinez.customers.infrastructure.CustomerApiController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

public class CustomerApiControllerTest {

    @Mock
    private CustomerCreator customerCreator;

    @Mock
    private CustomerSearcher customerSearcher;

    private CustomerApiController customerApiController;

    private CustomerDto customerDto;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        customerApiController =
                spy(new CustomerApiController(
                        customerCreator,
                        customerSearcher));

        customerDto = new CustomerDto();
        customerDto.setLastName("Martinez");
        customerDto.setName("Leandro");
        customerDto.setEmail("martinezleandro044@gmail.com");
    }

    @Test
    public void createCustomer_ok()  {
        doNothing().when(customerCreator).create(customerDto.getName(), customerDto.getLastName(), customerDto.getEmail());

        ResponseEntity<Void> responseEntity = customerApiController.createCustomer(customerDto);
        assertThat(responseEntity.getStatusCodeValue(), is(200));

        verify(customerCreator, times(1)).create(customerDto.getName(), customerDto.getLastName(), customerDto.getEmail());
        verifyNoInteractions(customerSearcher);
    }

    @Test
    public void getCustomer_ok()  {
        Customer customer = new Customer("Leandro", "Martinez", "martinezleandro044@gmail.com");

        when(customerSearcher.findById(1)).thenReturn(customer);

        ResponseEntity<CustomerDto> responseEntity = customerApiController.getCustomer(1);

        assertThat(responseEntity.getStatusCodeValue(), is(200));
        assertThat(responseEntity.getBody().getName(), is(customer.getFirstName()));
        assertThat(responseEntity.getBody().getLastName(), is(customer.getLastName()));
        assertThat(responseEntity.getBody().getEmail(), is(customer.getEmail()));

        verify(customerSearcher, times(1)).findById(1);
        verifyNoInteractions(customerCreator);
    }

}
