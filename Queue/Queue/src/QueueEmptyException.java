/**
 * Runtime exception thrown when tries to perform dequeue or front operation
 * on an empty queue.
 *  
 * @author Richard Bryann Chua
 *
 */
public class QueueEmptyException extends RuntimeException {
	public QueueEmptyException(String err) {
		super(err);
	}
}
