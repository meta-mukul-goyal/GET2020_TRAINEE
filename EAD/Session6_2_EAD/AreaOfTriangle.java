package saopwebservice;

public class AreaOfTriangle {
	public double triangleArea(double side1, double side2, double side3){
		double perimeter = (double)(side1+side2+side3)/2;
		return (double)Math.sqrt(perimeter*(perimeter-side1)*(perimeter-side2)*(perimeter-side3));
	}
}