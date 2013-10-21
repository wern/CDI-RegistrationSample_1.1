package de.mathema.campus;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.mathema.campus.qualifiers.Registered;
import de.mathema.campus.stereotypes.SingletonService;

@SingletonService
@Dependent
@Stateless
public class Registration implements IRegistration {

	@PersistenceContext
	private EntityManager entityManager;

	@Inject @Registered
	private Event<Customer> newCustomerEvent;

	/* (non-Javadoc)
	 * @see de.mathema.campus.IRegistration#register(de.mathema.campus.Customer)
	 */
	public String register(Customer customer) {
		Customer pCust = new Customer(customer);
		entityManager.persist(pCust);
		newCustomerEvent.fire(pCust);
		return "confirmation";
	}
}
