package EAD6.com.assignment;

import javax.xml.bind.annotation.XmlRootElement;

public class BookDetail {
	private int idbook;
	private String title;
	private String writer;
	private String publisher;
	private int publishedyear;
	
	public BookDetail() {}
	
	public BookDetail(int idbook, String title, String writer, String publisher, int publishedyear) {
		this.idbook = idbook;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.publishedyear = publishedyear;
	}
	
	public int getidBook() {
		return idbook;
	}
	
	public void setidBook(int idbook) {
		this.idbook = idbook;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public int getPublishedyear() {
		return publishedyear;
	}
	
	public void setPublishedyear(int publishedyear) {
		this.publishedyear = publishedyear;
	}
	
}
