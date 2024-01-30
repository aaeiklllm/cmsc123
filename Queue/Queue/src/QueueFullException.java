/**
 * Runtime exception thrown when the operation enqueue if performed
 * on an array queue if the queue is already full.
 * 
 * @author Richard Bryann Chua
 *
 */
public class QueueFullException extends RuntimeException {
	public QueueFullException(String err) {
		super(err);
	}
}
