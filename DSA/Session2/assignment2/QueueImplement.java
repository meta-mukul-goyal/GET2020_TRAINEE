package assignment2;

public class QueueImplement {
	private static int queue[] = new int[5], front, rear, size;
	
	private static boolean isFull() {
		if (size == queue.length)
			return true;
		return false;
	}
	
	private static void enqueue(int data) {
		if (isFull())
			System.out.println("queue is full");
		else{
			size++;
			front = front%(queue.length);
			queue[front++] = data;
			System.out.println("enqueue "+data);
		}
	}

	private static int dequeue() {
		if (isEmpty()){
			System.out.println("queue is empty");
			return 0;
		}
		else{
			size--;
			return queue[rear++];
		}
	}
	
	private static boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

	private static void display() {
		if (front <= rear){
			for (int i=rear; i<queue.length; i++)
				System.out.print("->" +queue[i]);
			for (int i=0; i!=front; i++)
				System.out.print("->" +queue[i]);
		}
		else
			for (int i=rear; i<front; i++)
				System.out.print("->" +queue[i]);
	}

	
	public static void main(String[] args){
		enqueue(1);
		enqueue(2);
		enqueue(3);
		enqueue(4);
		enqueue(5);
		System.out.println("dequeue " +dequeue());
		System.out.println("dequeue " +dequeue());
		enqueue(6);
		enqueue(7);
		enqueue(8);
		display();
	}

}
