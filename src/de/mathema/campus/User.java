package de.mathema.campus;

import java.io.Serializable;

@SuppressWarnings("serial")
public class User implements Serializable{

	private String vorname = "Gast";
	private String nachname = "Gast";

	public User() {
	}

	public User(String vorname, String nachname) {
		this.vorname = vorname;
		this.nachname = nachname;
	}

	public String getVorname() {
		return vorname;
	}

	public String getNachname() {
		return nachname;
	}

	@Override
	public String toString() {
		return "User [nachname=" + nachname + ", vorname=" + vorname + "]";
	}


}
