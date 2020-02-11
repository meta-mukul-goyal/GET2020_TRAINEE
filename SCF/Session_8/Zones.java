package zoo;

import java.util.ArrayList;

public class Zones {
	final int limitOfCages;
	String typeOfZone;
//	final int zoneId;
//	static int counter = 0;
	ArrayList<Cage> listOfCages = new ArrayList<Cage>();
	
	public Zones(int capacityForCagesInZone,String zoneType) {
		
		limitOfCages = capacityForCagesInZone;
		typeOfZone = zoneType;
//		zoneId = counter++;
	}
	
//	public void AddCage(){
//		
//	}
}
