public class LinkedQueue<E> implements Queue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public E front() throws QueueEmptyException {
        if (isEmpty()){
            throw new QueueEmptyException("Queue is empty!");
        }
        else {
            return front.getKey();
        }
    }

    @Override
    public void enqueue(Object element) {
        if (isEmpty()){
            front = new Node(element, null);
            rear = front;
        }

        else {
            Node newNode = new Node(element, null); //key, next //make new node
            rear.setNext(newNode); //set that new node next to rear
            rear = newNode; //turn that node into the new rear
        }
        size++;
    }

    @Override
    public E dequeue() throws QueueEmptyException {
        if (isEmpty()){
            throw new QueueEmptyException("Queue is empty!");
        }
        else {
            Object temp = front.getKey();
            front = front.getNext();
            size--;
            return (E) temp;
        }
    }
}


