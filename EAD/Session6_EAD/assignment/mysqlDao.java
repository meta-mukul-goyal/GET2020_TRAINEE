package EAD6.com.assignment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class mysqlDao {
	ArrayList<BookDetail> bookList = new ArrayList<BookDetail>();
	PreparedStatement ps; 
	ResultSet rs;
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
	
	public ArrayList<BookDetail> addItem(BookDetail bookObj) throws ClassNotFoundException, SQLException {
		try {
			Connection con = mysqlConnection.initializeDatabase();
			ps=con.prepareStatement("insert into book values(idbook,?,?,?,?)"); 
			ps.setString(1, bookObj.getTitle());
			ps.setString(2, bookObj.getWriter());
			ps.setString(3, bookObj.getPublisher());
			ps.setInt(4, bookObj.getPublishedyear());
			
			if(ps.executeUpdate()>0) {
				System.out.println("Added successfully");
				con.close();
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		} 
		return getAllBooks(null);
	}
	
	public ArrayList<BookDetail> getAllBooks(String title) throws ClassNotFoundException, SQLException{
		try {
			Connection con = mysqlConnection.initializeDatabase();
			if ( title != null ) {
				ps=con.prepareStatement("select * from book where title=?");
				ps.setString(1, title);
			}
			else 
				ps=con.prepareStatement("select * from book");
			rs = ps.executeQuery();
			while(rs.next())
				bookList.add( new BookDetail( rs.getInt("idbook"), rs.getString("title"), rs.getString("writer"), rs.getString("publisher"), rs.getInt("publishedyear") ));
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			} 
		return bookList;	
	}

	public ArrayList<BookDetail> updateBook(BookDetail bookObj) throws ClassNotFoundException, SQLException {
		try {
			Connection con = mysqlConnection.initializeDatabase();
			ps=con.prepareStatement( "Update book set title=?, publishedyear=? where idbook=?");
			ps.setString(1, bookObj.getTitle());
			ps.setInt(2, bookObj.getPublishedyear());
			ps.setInt(3, bookObj.getidBook());
		if ( ps.executeUpdate() > 0) 
			System.out.println("Record Updated Successfully");
		} 
		catch (SQLException sql) {
			sql.printStackTrace();
		}
		return getAllBooks(null); 
	}

	public  ArrayList<BookDetail> deleteAllBook(String id) throws ClassNotFoundException, SQLException {
		try {
			Connection con = mysqlConnection.initializeDatabase();
			if ( id!=null ) {
				ps=con.prepareStatement("delete from book where idbook=?");
				ps.setInt(1, Integer.parseInt(id));
			}
			else
				ps=con.prepareStatement("truncate table book");
			if ( ps.executeUpdate() > 0) 
					con.close();
		}
		catch (SQLException sql) {
			sql.printStackTrace();
		}
		return getAllBooks(null);
	}

}
