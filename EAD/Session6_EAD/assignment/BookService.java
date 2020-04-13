package EAD6.com.assignment;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("bookservice")
public class BookService {
	mysqlDao dao = new mysqlDao();
	
	@POST
	@Path("book")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<BookDetail> addItem(BookDetail bookObj)
								throws ClassNotFoundException, SQLException{
		return dao.addItem(bookObj);
	}
	
	@GET
	@Path("/book")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<BookDetail> getAllItems(@QueryParam("title") String title) throws ClassNotFoundException, SQLException {
		return dao.getAllBooks(title);
	}
	
//	@GET
//	@Path("/book")
//	@Produces(MediaType.APPLICATION_JSON)
//	public BookDetail getAllItems(@PathParam("title") String title) throws ClassNotFoundException, SQLException {
//		return dao.getByTitle(title);
//	}

	@PUT
	@Path("/book")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<BookDetail> updateBook(BookDetail bookObj) throws ClassNotFoundException, SQLException {
		 return dao.updateBook(bookObj);
	}
	
//	@DELETE
//	@Path("/book/{id}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public ArrayList<BookDetail> deleteById(@PathParam("id") int id) throws ClassNotFoundException, SQLException{
//		return dao.deleteById(id);
//	}
	
	@DELETE
	@Path("/book")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public  ArrayList<BookDetail> deleteAllBook(@QueryParam("id") String id) throws ClassNotFoundException, SQLException{
		return dao.deleteAllBook(id);
	}
}
