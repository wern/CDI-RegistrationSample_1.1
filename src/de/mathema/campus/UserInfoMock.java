package de.mathema.campus;

import java.security.Principal;

public class UserInfoMock extends UserInfo {

	@Override
	//@Specializes @Produces
	public User getUserLoggedIn(Principal principal) {
		return new User("The Mock","Muck");
	}

}
