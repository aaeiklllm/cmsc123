/**
 * Driver for the queue class.
 * 
 * @author Richard Bryann Chua
 *
 */
public class QueueDriver {

	public static void main(String[] args) {
		Queue<Integer> q = new ArrayQueue<Integer>(10);
		
		for(int i = 0; i < 5; i++) {
			q.enqueue(i);			
		}
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		
		for(int i = 0; i < 7; i++) {
			q.enqueue(i);
		}
		
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		
		Queue<String> q1 = new ArrayQueue<String>();
		q1.enqueue("Hello");
		q1.enqueue("World");
		System.out.println(q1.dequeue());
		System.out.println(q1.dequeue());
	}

}
