
package com.tradingscreen.analytics;

import java.util.Objects;

public class Person {
	private final int id;
	private final String name;

	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int id() {
		return id;
	}

	public String name() {
		return name;
	}

	@Override
	public int hashCode() {
		int hash =7;
		hash = 31 * hash + this.id;
		hash = 31 * hash + Objects.hashCode(this.name);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {return true;}
        if (obj == null) {return false;}
		if(obj == null || obj.getClass()!= this.getClass()) {return false;}
		
		Person person = (Person) obj;
		return (this.id == person.id && this.name.equals(person.name));
	}
}
