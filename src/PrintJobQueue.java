import java.util.NoSuchElementException;

public class PrintJobQueue extends Object implements QueueADT<PrintJob> {

    private LinkedNode<PrintJob> front; // reference to the front of the queue
    private LinkedNode<PrintJob> back; // reference to the rear of the queue
    private int size; // number of elements in the queue

    public PrintJobQueue() {
        front = null;
        back = null;
        size = 0;
    }

    @Override
    public void enqueue(PrintJob value) {
        LinkedNode<PrintJob> newNode = new LinkedNode<>(value);
        if (isEmpty()) {
            front = newNode;
            back = newNode;
            size++;
        } else {
            back.setNext(newNode);
            back = newNode;
            size++;
        }
    }

    @Override
    public PrintJob dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Queue");
        }
        PrintJob result = front.getData();
        front = front.getNext();
        size--;
        if (isEmpty()) {
            back = null;
        }
        return result;
    }

    @Override
    public PrintJob peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty Queue");
        }
        return front.getData();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(PrintJob value) {
        LinkedNode<PrintJob> current = front;
        while (current != null) {
            if (current.getData().equals(value)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public void clear() {
        front = null;
        back = null;
        size = 0;
    }

    public PrintJob[] getList() {
        PrintJob[] result = new PrintJob[size];
        PrintJob[] r = new PrintJob[0];
        LinkedNode<PrintJob> current = front;
        if (current == null) {
            return r;
        }
        for (int i = 0; i < size; i++) {
            if (current == null) {
                break;
            }
            if (current.getData() == null) {
                break;
            }
            result[i] = current.getData();
            current = current.getNext();
        }
        return result;
    }

    protected boolean equalsTo(LinkedNode<PrintJob> head, LinkedNode<PrintJob> back, int size) {
        // Check size
        if (this.size != size) {
            return false;
        }
        // compare each node
        LinkedNode<PrintJob> current1 = this.front;
        LinkedNode<PrintJob> current2 = head;
        while (current1 != null && current2 != null) {
            if (!current1.getData().equals(current2.getData())) {
                return false;
            }
            current1 = current1.getNext();
            current2 = current2.getNext();
        }
        // Check if both lists are null at the same time
        if (current1 != null || current2 != null) {
            return false;
        }
        return true;
    }
}
