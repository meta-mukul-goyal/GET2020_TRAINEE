package Controller;

import java.util.ArrayList;
import java.util.HashMap;

import Facade.*;
import enum_package.*;

public class ProjectController {
	static FacadeOperation foObj = new FacadeOperation();
	
	public static boolean checkProductCode(int ProductCode) {
		return foObj.checkProductCode(ProductCode);
	}
	
	public static ArrayList<Product> displayItemList(){									// SHOW ITEM CART
		return foObj.displayItemList();
	}

	public static Status add(int productCode,int quantity){			// TO ADD NEW ITEM AND UPDATE THE ITEM
		return foObj.add(productCode, quantity);
	}

	public static HashMap<Integer, Integer> displayUserCart(){								// TO DISPLAY THE USER CART
		return foObj.displayUserCart();
	}
	
	public static Status remove(int ProductCode, int quantity){		// TO REMOVE THE ITEM FROM THE USER CART
		return foObj.remove(ProductCode, quantity);
	}
}
