package Facade;

public class Product {
	private int productCode;
	private String type;
	private String name;
	private int price;
	
	public Product(int productCode, String type, String name, int price) {
		this.productCode = productCode;
		this.type = type;
		this.name = name;
		this.price = price;
	}

	public int getProductCode() {
		return productCode;
	}
	
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
}
