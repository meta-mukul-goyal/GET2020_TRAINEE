package assignment2;


public class Queue {
	private static int front = -1;
	private static int rear = -1;
	private static int maxSize=100;
	private static Student queue[] = new Student[100];

	static boolean enQueue(Student item) {

		System.out.println("Im in enQueue()" + "Student Name : " + item.getName());
		if (isFull())
			return false;
		else {
			if (rear == front && front == -1) {
				front = 0;
				queue[++rear] = item;
			}
			else{
				queue[++rear] = item;
			}
			System.out.println(queue[rear].getName() + front + rear);
			return true;
		}
	}

	static Student deQueue() {
		if (isEmpty())
			return null;
		else {
			Student item = queue[front];
			if (rear == front) {
				rear = -1;
				front = -1;
			}
			else
				front++;

			System.out.println(item.getName() + "is dequeued");
			return item;
		}
	}

	static boolean isFull() {
		if ((rear + 1) % maxSize == front) {
			System.out.println("queue is full");
			return true;
		}
		return false;
	}

	static boolean isEmpty() {
		if (front == rear && rear == -1 && front==-1) {
			System.out.println("queue is empty");
			return true;
		}
		return false;
	}

}
