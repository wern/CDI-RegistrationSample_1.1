package de.mathema.campus.listener;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class ScopeListener {
	
	public void newApplicationContext(@Observes @Initialized(ApplicationScoped.class) Object obj){
		System.out.println("CDI: Application Context started...");
		System.out.println("CDI: payload: "+ obj);
	}
	
	public void newSessionContext(@Observes @Initialized(SessionScoped.class) Object obj){
		System.out.println("CDI: Session Context started...");
		System.out.println("CDI: payload: "+ obj);
	}
	/*
	public void newConversationContext(@Observes @Initialized(ConversationScoped.class) Object obj){
		System.out.println("CDI: Conversation Context started...");
		System.out.println("CDI: payload: "+ obj);
	}

	public void newRequestContext(@Observes @Initialized(RequestScoped.class) Object obj) {
		System.out.println("CDI: Request Context started...");
		System.out.println("CDI: payload: "+ obj);
	}
	 */
}
