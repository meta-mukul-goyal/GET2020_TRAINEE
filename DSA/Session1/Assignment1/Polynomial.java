package Assignment1;

public class Polynomial {
	static Term header = null;
	static Power tempHead;
	
	private static boolean addTerm(int coff, int[] power) {
		int i = 0;
		tempHead = null;
		while (i != power.length){
			Power newNode1 = new Power(power[i]);
			System.out.println(power[i]);
			if (tempHead == null)
				tempHead = newNode1;
			else{
				Power curr = tempHead;
				while (curr.next != null)
					curr = curr.next;
				curr.next = newNode1;
			}
			i++;
		}
		
		Term newNode = new Term(coff, tempHead);
		if (header == null)
			header = newNode;
		else{
			Term curr = header;
			while (curr.next != null)
				curr = curr.next;
			curr.next = newNode;
		}
		return true;
	}
	
	private static void display() {
		Term curr = header;
		char[] ch = {'x','y','z'};
		
		while (curr != null){
			int i = 0;
			System.out.print(curr.coefficient);
			Power pheader = curr.pow;
			while( i < ch.length){
				System.out.print(ch[i++]);
				System.out.print(pheader.degreeOfVariant);
				pheader = pheader.next;
			}
			System.out.print(" + ");
			curr = curr.next;
		}
	}
	
	public static void main(String[] args){
		int[] a = {2,1,0};
		System.out.println(Polynomial.addTerm(3,a));
		int[] b = {1,2,1};
		System.out.println(Polynomial.addTerm(1,b));
		int[] c = {3,1,3};
		System.out.println(Polynomial.addTerm(4,c));
		
		Polynomial.display();
	}
}
