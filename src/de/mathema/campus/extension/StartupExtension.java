package de.mathema.campus.extension;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessBean;

import de.mathema.campus.stereotypes.SingletonService;

public class StartupExtension implements Extension
{
	   private final Set<Bean<?>> startupBeans = new LinkedHashSet<Bean<?>>();
	 
	   <X> void processBean(@Observes ProcessBean<X> event)
	   {
	      if (event.getAnnotated().isAnnotationPresent(Startup.class) &&
	            event.getAnnotated().isAnnotationPresent(SingletonService.class))
	      {
	    	  System.out.println("CDI: Found @Startup in "+event.getBean().getName());
	         startupBeans.add(event.getBean());
	      }
	   }
	   
	   void afterDeploymentValidation(@Observes AfterDeploymentValidation event, BeanManager manager)
	   {
	      for (Bean<?> bean : startupBeans)
	      {
	    	  System.out.println("CDI: Starting "+bean.getName());
	         // the call to toString() is a cheat to force the bean to be initialized
	         manager.getReference(bean, bean.getBeanClass(), manager.createCreationalContext(bean)).toString();
	      }
	   }

}
