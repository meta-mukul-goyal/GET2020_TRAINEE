package zoo;

import java.util.LinkedList;

public class Zoo {
	
	// tiger ----- String type,int age,String name, String category, float weight, int speed,String sound
	//zone ------int capacityForCagesInZone,String zoneType
	// cage ---- String typeOfAnimal, int capacity
	
	private LinkedList<Zones> listOfZones = new LinkedList<Zones>();
	
	public boolean addZone(int capacityOfCages, String zoneType){
		Zones zoneObj = new Zones(capacityOfCages, zoneType);
		listOfZones.push(zoneObj);
		return true;
	}
	
	public boolean addCage(String zoneType,String animalBreed, int capacity){
		Cage cageObj = new Cage(animalBreed, capacity);
		for ( int i=0; i<listOfZones.size(); i++ ){
			if( listOfZones.get(i).typeOfZone == zoneType && listOfZones.get(i).limitOfCages > listOfZones.get(i).listOfCages.size() ){
				listOfZones.get(i).listOfCages.add(cageObj);
				return true;
			}
		}
		return false;
	}
	
	//mammal
	public boolean addAnimal(String type,int age,String name, String category, float weight, int speed,String sound){
		Animal animalObj = 	AnimalTypeFactory.addAnimal(type, age, name, category, weight, speed, sound);
		System.out.println("ïn 1");
		for ( int i=0; i<listOfZones.size(); i++ ){
			if ( listOfZones.get(i).typeOfZone == category ){
				for ( int j =0; j<listOfZones.get(i).listOfCages.size(); j++ ){
					if(listOfZones.get(i).listOfCages.get(j).animalBreed == type &&
							listOfZones.get(i).listOfCages.get(j).capacityOfCage >listOfZones.get(i).listOfCages.get(j).listOfAnimal.size()){
						listOfZones.get(i).listOfCages.get(j).listOfAnimal.put(name, animalObj);
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	//bird
	public boolean addAnimal(String type,int age,String name, String category, float weight, boolean canFly,String sound){
		Animal animalObj = 	AnimalTypeFactory.addAnimal(type, age, name, category, weight, canFly, sound);
		System.out.println("in 2");
		for ( int i=0; i< listOfZones.size(); i++ ){
			if( listOfZones.get(i).typeOfZone == category ){
				for ( int j =0; j < listOfZones.get(i).listOfCages.size(); j++ ){
					if( listOfZones.get(i).listOfCages.get(j).animalBreed == type &&
							listOfZones.get(i).listOfCages.get(j).capacityOfCage >listOfZones.get(i).listOfCages.get(j).listOfAnimal.size() ){
						listOfZones.get(i).listOfCages.get(j).listOfAnimal.put(name, animalObj);
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	//reptile
	public boolean addAnimal(String type,int age,String name, String category, float weight, String swim,String sound){
		Animal animalObj = 	AnimalTypeFactory.addAnimal(type, age, name, category, weight, swim, sound);
		System.out.println("ïn 1");
		for ( int i=0; i< listOfZones.size(); i++ ){
			if ( listOfZones.get(i).typeOfZone == category ){
				for ( int j =0; j < listOfZones.get(i).listOfCages.size(); j++ ){
					if ( listOfZones.get(i).listOfCages.get(j).animalBreed == type &&
							listOfZones.get(i).listOfCages.get(j).capacityOfCage >listOfZones.get(i).listOfCages.get(j).listOfAnimal.size() ){
						listOfZones.get(i).listOfCages.get(j).listOfAnimal.put(name, animalObj);
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	
	public boolean removeAnimal(String category,String breed,String name){
		for ( int i=0; i<listOfZones.size(); i++ ){
			if ( listOfZones.get(i).typeOfZone==category ){
				for ( int j =0; j<listOfZones.get(i).listOfCages.size(); j++ ){
					if ( listOfZones.get(i).listOfCages.get(j).animalBreed == breed && listOfZones.get(i).listOfCages.get(j).listOfAnimal.containsKey(name) ){
						listOfZones.get(i).listOfCages.get(j).listOfAnimal.remove(name);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	public static void main(String[] args){
		Zoo obj = new Zoo();
		boolean check = false;
		check = obj.addZone(2, "mammal");
		System.out.println(check);
		System.out.println("-------1--------");
		
		check = obj.addZone(1, "reptile");
		System.out.println(check);
		System.out.println("--------2-------");
		
		check = obj.addZone(1, "bird");
		System.out.println(check);
		System.out.println("---------3------");
		
		check = obj.addCage("mammal", "tiger", 2);
		System.out.println(check);
		System.out.println("----------4-----");
		
		check = obj.addCage("bird","eagle", 1);
		System.out.println(check);
		System.out.println("-----------5----");
		
		check = obj.addCage("reptile","crocodile", 1);
		System.out.println(check);
		System.out.println("----------6-----");
		
		check = obj.addAnimal("tiger", 10, "ramu", "mammal", 50.00f, 65, "roar");
		System.out.println(check);
		System.out.println("-----------7----");
		
		check = obj.removeAnimal("mammal", "tiger", "ramu");
		System.out.println(check);
		System.out.println("----------8-----");
		
		check = obj.removeAnimal("reptile", "crocodile", "shyamu");
		System.out.println(check);
		System.out.println("---------9------");
		
		check = obj.addAnimal("eagle", 5, "chiya", "bird", 10.00f, check, "beep");
		System.out.println(check);
		System.out.println("----------10-----");
		
		check = obj.addAnimal("eagle", 5, "chiya", "bird", 10.00f, check, "beep");
		System.out.println(check);
		System.out.println("----------11-----");
		
		check = obj.addAnimal("tiger", 10, "ramu", "mammal", 50.00f, 65, "roar");
		System.out.println(check);
		System.out.println("----------12-----");
	}
}
