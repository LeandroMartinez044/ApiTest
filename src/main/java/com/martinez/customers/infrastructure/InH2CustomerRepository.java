package com.martinez.customers.infrastructure;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.martinez.customers.domain.CustomerRepository;
import com.martinez.customers.domain.Customer;
import com.martinez.utils.Validate;

/** The repository for customer.
 */
@Component
@Qualifier(value="InH2CustomerRepository")
public class InH2CustomerRepository implements CustomerRepository {

    /** The Jpa Entity Manager, never null.
     */
    private final EntityManager entityManager;

    /** Constructor, builds a InH2CustomerRepository repository.
     *
     * @param theEntityManager the entity manager to use. It cannot be null.
     */
    public InH2CustomerRepository(EntityManager theEntityManager) {
        Validate.notNull(theEntityManager, "The entity manager cannot be null.");
        entityManager = theEntityManager;
    }

    /** Saves the customer to this repository.
     *
     * @param customer the customer to save. It cannot be null.
     */
    @Transactional
    @Override
    public void save(Customer customer) {
        Validate.notNull(customer, "customer cannot be null");
        entityManager.persist(customer);
    }

    /** Gets the customer from this repository.
     *
     * @param idCustomer the card art to get. It cannot be null.
     *
     * @return Customer. Could be null if a customer with the given customer id doesn't
     * exist.
     */
    @Override
    public Customer findById(Integer idCustomer) {
        Validate.notNull(idCustomer, "customer id cannot be null");
        return entityManager.find(Customer.class, idCustomer);
    }

    /** Deletes a customer from this repository.
     *
     * @param customer the customer to be deleted. Cannot be null.
     */
    @Override
    public void delete(Customer customer) {
        Validate.notNull(customer, "customer cannot be null");
        entityManager.remove(customer);
    }
}
