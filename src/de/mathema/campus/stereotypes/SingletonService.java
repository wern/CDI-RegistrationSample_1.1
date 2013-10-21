package de.mathema.campus.stereotypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;

import de.mathema.campus.stereotypes.bindings.Traced;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ApplicationScoped
@Named
@Traced
@Stereotype
public @interface SingletonService {
}
