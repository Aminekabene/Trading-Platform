
package com.tradingscreen.analytics;

import java.util.Objects;

public class Trader extends Person {

	private final String city;

	public Trader(int id, String name, String city) {
		super(id, name);
		this.city = city;
	}

	public String city() {
		return city;
	}

	@Override
	public int hashCode() {
		int hash = super.hashCode();
		hash = 31 * hash + Objects.hashCode(this.city);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj) {return true;}
        if (obj == null) {return false;}
		
		if(obj == null || obj.getClass()!= this.getClass()) {return false;}
		
		Trader trader = (Trader) obj;
		return (super.equals(trader) && this.city.equals(trader.city));
	}
}
