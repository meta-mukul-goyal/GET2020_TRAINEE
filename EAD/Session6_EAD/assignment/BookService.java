package EAD6.com.assignment;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("bookservice")
public class BookService {
	mysqlDao dao = new mysqlDao();
	
	@POST
	@Path("book/{title}/{writer}/{publisher}/{publishedyear}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<BookDetail> addItem(@PathParam("title") String title, @PathParam("writer") String writer, 
						@PathParam("publisher") String publisher, @PathParam("publishedyear") int publishedyear)
								throws ClassNotFoundException, SQLException{
		System.out.println(title);
		return dao.addItem(title, writer, publisher, publishedyear);
	}
	
	@GET
	@Path("/book")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<BookDetail> getAllItems() throws ClassNotFoundException, SQLException {
		return dao.getAllBooks();
	}
	
	@GET
	@Path("/book/{title}")
	@Produces(MediaType.APPLICATION_JSON)
	public BookDetail getAllItems(@PathParam("title") String title) throws ClassNotFoundException, SQLException {
		return dao.getByTitle(title);
	}

	@PUT
	@Path("/book/{title}/{publishedyear}/{idbook}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<BookDetail> updateBook(@PathParam("title") String title, @PathParam("publishedyear") int publishedyear,
											 @PathParam("idbook") int idbook) throws ClassNotFoundException, SQLException {
		 return dao.updateBook(title, publishedyear, idbook);
	}
	
	@DELETE
	@Path("/book/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<BookDetail> deleteById(@PathParam("id") int id) throws ClassNotFoundException, SQLException{
		return dao.deleteById(id);
	}
	
	@DELETE
	@Path("/book")
	@Produces(MediaType.APPLICATION_JSON)
	public  ArrayList<BookDetail> deleteAllBook() throws ClassNotFoundException, SQLException{
		return dao.deleteAllBook();
	}
}
