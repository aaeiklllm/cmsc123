/**
 * Interface for a queue: a collection of objects that are inserted
 * according to the first-in first-out principle
 * 
 * @author Richard Bryann Chua
 * 
 * Adapted from the book 
 * "Data Structures and Algorithms in Java"
 * by Michael Goodrich and Robert Tamassia
 *
 */
public interface Queue<E> {
	/**
	 * Returns the number of elements in the queue
	 * @return number of elements in the queue
	 */
	public int size();
	
	/**
	 * Returns whether the queue is empty
	 * @return true if the queue is empty, false otherwise
	 */
	public boolean isEmpty();
	
	/**
	 * Inspects the element at the front of the queue.
	 * @return element at the front of the queue
	 * @throws QueueEmptyException if the queue is empty
	 */
	public E front() throws QueueEmptyException;
	
	/**
	 * Inserts an element at the rear of the queue.
	 * @param element new element to be inserted.
	 */
	public void enqueue(E element);
	
	/**
	 * Removes the element at the front of the queue.
	 * @return element removed
	 * @throws QueueEmptyException if the queue is empty
	 */
	public E dequeue() throws QueueEmptyException;
}
