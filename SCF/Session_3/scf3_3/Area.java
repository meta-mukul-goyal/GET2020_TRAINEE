package scf3_3;

public class Area {
	
	/**
	 * find the area of the triangle
	 * @param width as a input
	 * @param height as a input
	 * @return area of triangle
	 */
	public double triangleArea(double width, double height){
		return (0.5*(width*height));
	}
	
	/**
	 * find the area of the rectangle
	 * @param width as a input
	 * @param height as a input
	 * @return area of rectangle
	 */
	public double rectangleArea(double width, double height){
		return width*height;
	}
	
	/**
	 * find the area of the square
	 * @param width as a width
	 * @return area of square
	 */
	public double squareArea(double width){
		return width*width;
	}
	
	/**
	 * find the area of circle
	 * @param radius as a input
	 * @return area of circle
	 */
	public double circleArea(double radius){
		return Math.PI*radius*radius;
	}
	
}
