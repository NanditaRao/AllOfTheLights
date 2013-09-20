package org.ASE.model;

import java.io.Serializable;

public class checkbox  implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private boolean selected;

public boolean getSelected()
{
  return selected;
}

public void setSelected(boolean selected)
{
	System.out.println("Hello from checkbox");
	this.selected = selected;
}
                                        
}
