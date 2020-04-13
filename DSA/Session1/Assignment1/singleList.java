package Assignment1;

public class singleList {
	static Node header = null;
	static int length = 0;
	
	//create the linklist
	public static void addNode(int data) {
		Node newNode = new Node(data);
		length++;
		Node curr;
		if (header == null)
			header = newNode;
		else{
			curr = header;
			while(curr.next != null)
				curr = curr.next;
			curr.next = newNode; 
		}
	}
	
	//display the linklist
	public static void display() {
		Node curr = header;
		while(curr != null){
			System.out.print("->" + curr.data);
			curr = curr.next;
		}
	}
	
	//rotate the sublist of linklist
	private static int rotate(int L, int R, int N) {
		Node curr = header, prevOfL=null, prev=null, nodeAtRotaingNode=null;
		int count = 1, rotateNodes = R-L+1, rotatingNode = rotateNodes-N+1;
		if (N % rotateNodes == 0)
			return 0;
		while(count != R){
			if(count == L-1)
				prevOfL = curr;
			if(count == rotatingNode){
				prev = curr;
				nodeAtRotaingNode = curr.next;
			}
			curr = curr.next; 
			count++;
		}
		prev.next = curr.next;
		curr.next = prevOfL.next;
		prevOfL.next = nodeAtRotaingNode;
		return 1;	
	}
	
	//detect loop in linklist
	private static boolean detectLoop() {
		Node curr = header, fast = header;
		while(curr != null && fast != null && fast.next != null){
			curr = curr.next;
			fast = curr.next.next;
			if(curr == fast)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		int l=2, r=5, n=2;
		singleList.addNode(2);
		singleList.addNode(3);
		singleList.addNode(4);
		singleList.addNode(5);
		singleList.addNode(6);
		singleList.addNode(7);
//		singleList.addNode(8);
//		singleList.addNode(9);
//		singleList.addNode(10);
//		singleList.addNode(11);
//		singleList.addNode(12);
		singleList.display();
		singleList.rotate(l, r, n);
		System.out.println("\nList After Rotating");
		singleList.display();

//		header.next.next.next.next = header.next.next;
		if(singleList.detectLoop()){
			System.out.println("\nLoop is Detect");
		}
		else
			System.out.println("\nLoop is not Detect");
		
	}
}
