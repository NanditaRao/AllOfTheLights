package org.ASE.model;

import java.io.Serializable;
import java.util.List;

public class CheckboxList implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private List<checkbox> addEvent ;
	




	public List<checkbox> getAddEvent() {
		return addEvent;
	}



	public void setAddEvent(List<checkbox> addEvent) {
		System.out.println("Hello from checkbox");
		this.addEvent = addEvent;
	}


}
