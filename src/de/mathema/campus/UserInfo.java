package de.mathema.campus;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import de.mathema.campus.qualifiers.Guest;
import de.mathema.campus.qualifiers.LoggedIn;
import de.mathema.campus.stereotypes.SingletonService;

@SingletonService
public class UserInfo {

	private final Map<String,User> users = new HashMap<String, User>();
	
	@PostConstruct
	void init(){
		System.out.println("CDI: Initialisiere BenutzerDB...");
		users.put("werner", new User("Werner", "Eberling"));
		users.put("CDI", new User("1.1","CDI"));
	}

	@Produces @SessionScoped @LoggedIn @Named("user")
	public User getUserLoggedIn(Principal principal){
		return users.get(principal.getName());
	}

	@Produces @SessionScoped @Guest
	public User getUserGuest(Principal principal){
		return new User("Der","Gast");
	}
}
