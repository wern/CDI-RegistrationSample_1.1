package de.mathema.campus;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@RequestScoped
@Named
@Entity
public class Customer implements Serializable{
	@Id @GeneratedValue
	private int id;
	@Size(min = 5, max = 25)
	private String nachname;
	@Size(min = 5, max = 25)
	private String vorname;
	@Pattern(regexp = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "keine gueltige emailadresse")
	private String email;
	
	public Customer() {
	}

	public Customer(Customer customer) {
		this.nachname = customer.getNachname();
		this.vorname = customer.getVorname();
		this.email = customer.getEmail();
	}
	
	public String getNachname() {
		return nachname;
	}

	public void setNachname(String name) {
		this.nachname = name;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
