package com.martinez.customers.domain;

public interface CustomerRepository {
    void save(Customer customer);
    Customer findById(Integer id);
    void delete(Customer customer);
}
