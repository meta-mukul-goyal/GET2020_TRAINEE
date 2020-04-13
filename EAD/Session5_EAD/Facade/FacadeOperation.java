package Facade;

import java.util.ArrayList;
import java.util.HashMap;

import Dao.ProjectDao;
import enum_package.*;

public class FacadeOperation {
	HashMap<Integer, Integer> userCart = new HashMap<Integer, Integer>();
	
	public boolean checkProductCode(int productCode) {
		for ( Product product : ProjectDao.getItemList() )
			if ( product.getProductCode() == productCode )
				return true;
		return false;
	}
	
	public ArrayList<Product> displayItemList(){									// SHOW ITEM CART
		return ProjectDao.getItemList();	}
	
	public Status add(int productCode,int quantity){			// TO ADD NEW ITEM AND UPDATE THE ITEM
		if ( userCart.containsKey(productCode)){
			int add_quantity = quantity + userCart.get(productCode);
			userCart.put(productCode,add_quantity);
			return Status.ITEM_IS_UPDATE;
		}
		else{
			userCart.put(productCode,quantity);
			return Status.ITEM_IS_ADDED;
		}
	}
	
	public Status remove(int ProductCode, int quantity){		// TO REMOVE THE ITEM FROM THE USER CART
		if ( userCart.containsKey(ProductCode)){
			if( userCart.get(ProductCode) > quantity ){
				int remove_quantity = userCart.get(ProductCode)-quantity;
				userCart.put(ProductCode,remove_quantity);
				return Status.ITEM_IS_UPDATE;
			}
			else if( userCart.get(ProductCode) <= quantity ){
				userCart.remove(ProductCode);
				return Status.ITEM_IS_DELETE;
			}	
		}
		return Status.ITEM_IS_NOT_AVAILABLE;
	}
	
	public HashMap<Integer, Integer> displayUserCart(){								// TO DISPLAY THE USER CART
		return userCart;
	}

	
}
