package com.martinez.customers.domain;

import javax.persistence.*;

import com.martinez.utils.Validate;

/**
 * Represents a customer.
 */
@Entity
public class Customer {

    /**
     * Represent the customer id. Never null.
     */
    @Id
    @GeneratedValue
    private Integer id;

    /**
     * Represent the customer email. Never blank.
     */
    @Column
    private String email;

    /**
     * Represent the customer first name. Never blank.
     */
    @Column
    private String firstName;

    /**
     * Represent the customer last name. Never blank.
     */
    @Column
    private String lastName;


    /**
     * Default constructor.
     */
    public Customer() {

    }

    /**
     * Constructor.
     *
     * @param theFirstName represents the customer name. Cannot be blank.
     *
     * @param theLastName represents the customer last name. Cannot be blank.
     *
     * @param theEmail represents the customer email. Cannot be blank.
     */
    public Customer(final String theFirstName, final String theLastName,
                    final String theEmail) {
        Validate.notBlank(theFirstName, "customer name cannot be blank");
        Validate.notBlank(theLastName, "customer last name cannot be blank");
        Validate.notBlank(theEmail, "customer email cannot be blank");

        firstName = theFirstName;
        lastName = theLastName;
        email = theEmail;
    }

    /** Returns the customer id.
     *
     * @return the customer id.
     */
    public Integer getId() {
        return id;
    }

    /** Returns the customer email.
     *
     * @return the customer email.
     */
    public String getEmail() {
        return email;
    }

    /** Returns the customer first.
     *
     * @return the customer first.
     */
    public String getFirstName() {
        return firstName;
    }

    /** Returns the customer last name.
     *
     * @return the customer last name.
     */
    public String getLastName() {
        return lastName;
    }
}
