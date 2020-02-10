package EAD6.com.assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class mysqlDao {
	ArrayList<BookDetail> bookList = new ArrayList<BookDetail>(); 
//	Connection con;
	
//	public mysqlDao()  {
//		try {
//			con = mysqlConnection.initializeDatabase();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	public ArrayList<BookDetail> addItem(String title, String writer, String publisher, int publishedyear) throws ClassNotFoundException, SQLException {
		try {
			Connection con = mysqlConnection.initializeDatabase();
			PreparedStatement ps=con.prepareStatement("insert into book values(idbook,?,?,?,?)"); 
			ps.setString(1, title);
			ps.setString(2, writer);
			ps.setString(3, publisher);
			ps.setInt(4, publishedyear);
			
			if(ps.executeUpdate()>0) {
				System.out.println("Added successfully");
				con.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		return getAllBooks();
	}
	
	public ArrayList<BookDetail> getAllBooks() throws ClassNotFoundException, SQLException{
		try {
			Connection con = mysqlConnection.initializeDatabase();
			PreparedStatement ps=con.prepareStatement("select * from book");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
				bookList.add( new BookDetail( rs.getInt("idbook"), rs.getString("title"), rs.getString("writer"), rs.getString("publisher"), rs.getInt("publishedyear") ));
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			} 
		return bookList;	
	}

	public BookDetail getByTitle(String title) throws ClassNotFoundException {
		try {
			Connection con = mysqlConnection.initializeDatabase();
			PreparedStatement ps=con.prepareStatement("select * from book where title=?");
			ps.setString(1, title);
			ResultSet rs = ps.executeQuery();
			rs.next();
				return new BookDetail( rs.getInt("idbook"), rs.getString("title"), rs.getString("writer"), rs.getString("publisher"), rs.getInt("publishedyear"));
			}	
			catch (SQLException e) {
				e.printStackTrace();
			} 
		return null;
	}


	public ArrayList<BookDetail> updateBook(String title, int publishedyear, int idbook) throws ClassNotFoundException, SQLException {
		try {
			Connection con = mysqlConnection.initializeDatabase();
			PreparedStatement ps=con.prepareStatement( "Update book set title=?, publishedyear=? where idbook=?");
			ps.setString(1, title);
			ps.setInt(2, publishedyear);
			ps.setInt(3, idbook);
		if ( ps.executeUpdate() > 0) 
			System.out.println("Record Updated Successfully");
		else 
			System.out.println("There is a problem in updating Record.");
		} 
		catch (SQLException sql) {
			sql.printStackTrace();
		}
		return getAllBooks(); 
	}

	public ArrayList<BookDetail> deleteById(int id) throws ClassNotFoundException, SQLException {
		try {
			Connection con = mysqlConnection.initializeDatabase();
			PreparedStatement ps=con.prepareStatement("delete from book where idbook=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		if ( ps.executeUpdate() > 0) {
			System.out.println("Record Successfully deleted");
		}
		else 
			System.out.println("There is a problem in updating Record.");
		} 
		catch (SQLException sql) {
			sql.printStackTrace();
		}
		return getAllBooks();
	}

	public  ArrayList<BookDetail> deleteAllBook() throws ClassNotFoundException, SQLException {
		try {
			Connection con = mysqlConnection.initializeDatabase();
			PreparedStatement ps=con.prepareStatement("truncate table book");
		if ( ps.executeUpdate() > 0) {
			System.out.println("Record Successfully deleted");
			con.close();
		}
		else 
			System.out.println("There is a problem in updating Record.");
		} 
		catch (SQLException sql) {
			sql.printStackTrace();
		}
		return getAllBooks();
	}

}
