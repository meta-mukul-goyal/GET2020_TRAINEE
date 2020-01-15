package shopping;

import java.util.HashMap;


public class UserCart {
	Item itemobj = new Item();
	HashMap<String, Integer> map = new HashMap<>();
	
	public boolean checkName(String name){				// TO CHECK THE ITEM PRESENT IN ITEM CART
		for ( int i=0; i<itemobj.itemname.length; i++){
			if ( name.equals(itemobj.itemname[i]))
				return true;
		}
		return false;
	}
	
	public void show(){									// SHOW ITEM CART
		System.out.println("Item Name\tItem Price ");
		System.out.println("----------------------------");
		for(int i=0; i<3; i++){
			System.out.println(itemobj.itemname[i]+"\t\t"+itemobj.itemprice[i]);
		}
		System.out.println("\nWhich Item You Want You Add:");
	}


	public void add(String name,int quantity){			// TO ADD NEW ITEM AND UPDATE THE ITEM
		if ( map.containsKey(name)){
			int add_quantity = quantity + map.get(name);
			System.out.println("Quantity is Updated " + name+ ": "+ map.get(name) + " --> "+ add_quantity);
			map.put(name,add_quantity);
		}
		else{
			map.put(name,quantity);
			System.out.println("Item "+ name+ " is Add to Cart");
		}
	}


	public void display(){								// TO DISPLAY THE USER CART
		if ( map.isEmpty() ){
			System.out.println("Your Cart Is Empty");
		}
		else{
			System.out.println("your cart with items:");
			System.out.println("----------------------------");
			System.out.println("Item Name\tItem quantity ");
			System.out.println("----------------------------");
			for ( String name : map.keySet()){
				System.out.println(name + "\t\t"+ map.get(name));
			}
		}
	}


	public void remove(String name, int quantity){		// TO REMOVE THE ITEM FROM THE USER CART
		int remove_quantity;
		if ( map.containsKey(name)){
			if( map.get(name) > quantity ){
				remove_quantity = map.get(name)-quantity;
				System.out.println("\nQuantity is Updated " + name+ ": "+ map.get(name) + "-->"+ remove_quantity);
				map.put(name,remove_quantity);
			}
			
			else if( map.get(name) == quantity ){
				map.remove(name);
				System.out.println("Item " + name+ " is Removed From Cart");
			}
			
			else if( map.get(name) < quantity )
				System.out.println("--->Available quantity of item is less than removed quantity");
		}
		else{
			System.out.println("--->Item is not in Your Cart");
		}
	}


	public void bill(){									// TO GENERAATE THE BILL 
		int amount=0,index=-1;
		System.out.println("Your Item Price List:");
		System.out.println("Itemname\t Quantity\t\t Price");
		System.out.println("--------------------------------------------");
		for(String name : map.keySet()){
			for(int i = 0; i < itemobj.itemname.length; i++)
				if (name.equals(itemobj.itemname[i])){
					index = i;
					break;
				};
				amount += itemobj.itemprice[index]*map.get(name);
				System.out.println( name +"\t\t\t"+ map.get(name)+ "\t\t" + itemobj.itemprice[index]*map.get(name));
		}
		System.out.println("--------------------------------------------");
		System.out.println("total amount: "+ amount);
		System.out.println("--------------------------------------------");
	}

}
