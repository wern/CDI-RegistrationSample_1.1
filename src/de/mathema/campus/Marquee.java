package de.mathema.campus;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import de.mathema.campus.qualifiers.Registered;
import de.mathema.campus.stereotypes.SingletonService;

@SingletonService
public class Marquee {

	@Produces @SessionScoped @Named
	private List<Customer> recentRegistrations = new ArrayList<Customer>();

	public void addRegistration(@Observes @Registered Customer customer){
		recentRegistrations.add(customer);
	}
}
