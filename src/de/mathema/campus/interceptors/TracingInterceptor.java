package de.mathema.campus.interceptors;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import de.mathema.campus.stereotypes.bindings.Traced;

@Traced
@Interceptor
@Priority(javax.interceptor.Interceptor.Priority.APPLICATION)
public class TracingInterceptor {

	@AroundInvoke
	public Object trace(InvocationContext ic) throws Exception {
		System.out.println("CDI: intercepting ...");
		System.out.println("CDI: Calling " + ic.getTarget() + "." + ic.getMethod());
		Object ret = ic.proceed();
		System.out.println("CDI: Returning " + ret);
		return ret;
	}
}
