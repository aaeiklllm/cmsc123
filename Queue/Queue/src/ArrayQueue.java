

/**
 * Array implementation of queue
 * 
 * @author Richard Bryann Chua
 *
 */
public class ArrayQueue<E> implements Queue<E> {
	/**
	 * Array that holds the elements of the queue.
	 */
	private E[] q;
	
	/**
	 * Index of the front of the queue.
	 */
	private int front = 0;
	
	/**
	 * Index of the rear of the queue.
	 */
	private int rear = 0;
	
	/**
	 * Maximum length of the queue
	 */
	private int capacity;
	
	/**
	 * Default size of the array for the queue when 
	 * the size of the array is not specified.
	 */
	private static final int CAPACITY = 100;
	
	/**
	 * Initialize the queue to use an array of default length CAPACITY
	 */
	public ArrayQueue() {
		this(CAPACITY);
	}
	
	/**
	 * Initialize the queue to use an array of given length
	 * 
	 * @param capacity length of the array
	 */
	public ArrayQueue(int capacity) {
		this.capacity = capacity;
		q = (E[]) new Object[capacity]; 
	}

	/* (non-Javadoc)
	 * @see Queue#dequeue()
	 */
	@Override
	public E dequeue() throws QueueEmptyException {
		// insert code here
		return null;
	}

	/* (non-Javadoc)
	 * @see Queue#enqueue(java.lang.Object)
	 */
	@Override
	public void enqueue(E element) throws QueueFullException {
		// insert code here
	}

	/* (non-Javadoc)
	 * @see Queue#front()
	 */
	@Override
	public E front() throws QueueEmptyException {		
		// insert code here
		return null;
	}

	/* (non-Javadoc)
	 * @see Queue#isEmpty()
	 */
	@Override
	public boolean isEmpty() {		
		// insert code here
		return true;
	}

	/* (non-Javadoc)
	 * @see Queue#size()
	 */
	@Override
	public int size() {		
		// insert code here
		return 0;
	}

}
