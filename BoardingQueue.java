
public class BoardingQueue {
	private final int CAPACITY = 10;
	private Passenger[] passengerQueue;
	private int front;
	private int rear;
	private int size;

	public BoardingQueue() {
		front = -1;
		rear = -1;
		passengerQueue = new Passenger[CAPACITY];

	}

	public BoardingQueue(int a) {//create queue of size a
		front = -1;
		rear = -1;
		passengerQueue = new Passenger[a];
	}
	
	public Passenger[] getArray() {//return queue
		return passengerQueue;
	}

	public void enqueuePassenger(Passenger newPass) throws FullQueueException {//adds passenger to queue
		if ((rear + 1) % CAPACITY == front) {
			throw new FullQueueException();
		}
		if (front == -1) {
			front=0;
			rear=0;
		} else {
			rear = (rear + 1) % CAPACITY;
		}
		passengerQueue[rear] = newPass;

	}

	public Passenger dequeuePassenger() throws EmptyQueueException {//removes passenger from queue
		Passenger answer;
		if (front == -1) {
			throw new EmptyQueueException();
		}
		answer = passengerQueue[front];
		if (front == rear) {
			front = -1;
			rear = -1;
		} else {
			front = (front + 1) % CAPACITY;
		}
		return answer;

	}

	public boolean isEmpty() {
		return (front == -1);
	}
	
	public int getSize() {
		return size;
	}
}
