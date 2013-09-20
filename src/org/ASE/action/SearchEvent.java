package org.ASE.action;

import java.util.ArrayList;
import java.util.List;

public class SearchEvent {
	private static List<String> searchEvent;
	public List<String> getSearchEvent() {
		return searchEvent;
	}



	public static void setSearchEvent(List<String> searchEvent) {
		searchEvent = searchEvent;
	}
	
	public static List<String> getInstance()
	{
		if(searchEvent == null || searchEvent.size() == 0)
		{
			searchEvent = new ArrayList<String>();
			for(int i=0;i<10;i++)
			{
				searchEvent.add(i,String.valueOf(i));
			}
		}	
		return searchEvent;
	}
}
