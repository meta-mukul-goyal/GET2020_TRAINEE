package EAD6.com.assignment;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("inventoryService")
public class InventoryService {
	InventoryDao dao = new InventoryDao();
	
	@GET
	@Path("/inventory")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Inventory> getAllItems() {
		return dao.getAllItems();
	}
	
	@GET
	@Path("/inventory/{itemname}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Inventory getItem(@PathParam("itemname") String itemname) {
		return dao.getItem(itemname);
	}
	
	@POST
	@Path("/inventory")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Inventory> addItem(Inventory inventoryObj){
		System.out.println(inventoryObj.getName());
		return dao.addItem(inventoryObj);
	}
	
	@PUT
	@Path("/inventory/{itemname}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Inventory> updateItem(Inventory inventoryObj, @PathParam("itemname") String itemname) {
		return dao.updateItem(inventoryObj, itemname);
	}
	
	@PUT
	@Path("/inventory")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Inventory> updateAll(ArrayList<Inventory> inventoryList) {
		return dao.updateAll(inventoryList);
	}
	
	@DELETE
	@Path("/inventory")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Inventory> deleteItems() {
		return dao.deleteitems();
	}
	
	@DELETE
	@Path("/inventory/{itemname}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<Inventory> deleteItem(@PathParam("itemname") String itemname) {
		return dao.deleteitems(itemname);
	}
	
}

