package de.mathema.campus.decorators;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.context.Conversation;
import javax.inject.Inject;

import de.mathema.campus.Customer;
import de.mathema.campus.IRegistration;
import de.mathema.campus.User;
import de.mathema.campus.qualifiers.Guest;
import de.mathema.campus.qualifiers.LoggedIn;

@Decorator
@Priority(javax.interceptor.Interceptor.Priority.APPLICATION)
public class RegistrationDecorator implements IRegistration {
	@Inject
	@Delegate
	private IRegistration delegate;

	@Inject
	private Conversation conversation;

	@Inject @LoggedIn
	private User loggedInUser;

	@Inject @Guest
	private User guestUser;

	@Override
	public String register(Customer customer) {
		System.out.println("CDI: decorating...");
		System.out.println("CDI: LoggedIn: "+ loggedInUser);
		System.out.println("Guest: "+ guestUser);
		if(customer.getNachname().toLowerCase().contains("begin")){
			conversation.begin();
		}

		if(customer.getNachname().toLowerCase().contains("end")){
			conversation.end();
		}
		customer.setNachname(customer.getNachname()+" {cId: "+conversation.getId()+"}");
		return delegate.register(customer);
	}
}
