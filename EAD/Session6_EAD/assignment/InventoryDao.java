package EAD6.com.assignment;

import java.util.ArrayList;

public class InventoryDao {
	ArrayList<Inventory> items = new ArrayList<Inventory>();
	
	public InventoryDao() {
		items.add(new Inventory("apples",3));
		items.add(new Inventory("oranges", 7));
		items.add(new Inventory("Pomegranates", 55));
	}
	
	public ArrayList<Inventory> getAllItems() {
		return items;
	}
	
	public Inventory getItem(String name) {
	    for(Inventory item : items)
	         if(item.getName().equals(name))
		            return item;
		      return null;
	}
	
	
	public ArrayList<Inventory> updateItem(Inventory inventoryObj, String itemname) {
	    for(Inventory item : items){
	         if(item.getName().equals(itemname)){
	            item.setName(inventoryObj.getName());
	            item.setQuantity(inventoryObj.getQuantity());
	            break;
	         }
	      }
	      return items;
	}

	public ArrayList<Inventory> deleteitems() {
		 items.clear();
		 return items;
	}
	
	public ArrayList<Inventory> deleteitems(String itemname) {
		 for(Inventory item : items)
	         if(item.getName().equals(itemname)) {
		            items.remove(item);
		      		return items;
	         }
		 return null;
	}

	public ArrayList<Inventory> updateAll(ArrayList<Inventory> inventoryList) {
		items.clear();
		 for(Inventory item : inventoryList)
			 items.add(item);
		 return items;
	}
	
	public ArrayList<Inventory> addItem(Inventory inventoryObj) {
		items.add(inventoryObj); 
		return items;
	}

}