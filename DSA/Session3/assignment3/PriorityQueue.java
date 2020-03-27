package assignment3;

public class PriorityQueue {

	private static int priQueue[] = new int[5], size;

	private static boolean isFull() {
		if (size == priQueue.length)
			return true;
		return false;
	}

	private static void enqueue(int data) {
		if (isFull())
			System.out.println("queue is full");
		else{
			int i;
			for (i=size-1; i>=0; i--)
				if (data > priQueue[i])
					priQueue[i+1] = priQueue[i];
				else
					break;
			priQueue[i+1] = data;
			size++;
		}
	}

	private static int dequeue() {
		if (isEmpty()){
			System.out.println("queue is empty");
			return 0;
		}
		else
			return priQueue[--size];
	}

	private static boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	private static void display() {
		for (int i=0; i<size; i++)
			System.out.print("->" +priQueue[i]);
	}


	public static void main(String[] args){
		enqueue(10);
		enqueue(2);
		enqueue(30);
		enqueue(4);
		enqueue(5);
		display();
		System.out.println("\ndequeue " +dequeue());
		System.out.println("dequeue " +dequeue());
		enqueue(6);
		enqueue(7);
		enqueue(8);
		display();
	}
}
